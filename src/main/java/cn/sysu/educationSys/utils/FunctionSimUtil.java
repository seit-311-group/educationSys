package cn.sysu.educationSys.utils;

import cn.sysu.educationSys.service.CoreProcessService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.*;

/**
 * 这个暂时没用了
 */
@Component
public class FunctionSimUtil {
    private static Logger logger = Logger.getLogger(FunctionSimUtil.class);

    private static final ExecutorService executorService = new ThreadPoolExecutor(
            2, 6, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
    );     // 不用反复的创建线程池
    private static final ExecutorCompletionService<Set<String>> completionService = new ExecutorCompletionService<>(executorService);

    static Set<String> OPS = new HashSet<String>(){{
        add("+");
        add("*");
    }}; // 可交换运算符

    /**
     * @param E1 源方程
     * @param E2 目标方程
     * @return
     */
    public double calSimilarity(String E1, String E2){
        logger.info(String.format("开始公式相似度匹配,E1源方程:%s;E2目标方程:%s", E1, E2));
        double sim = 0d;
        try {

            completionService.submit(new Callable<Set<String>>() {
                @Override
                public Set<String> call() throws Exception {
                    return preOperation(E1);
                }
            });
            completionService.submit(new Callable<Set<String>>() {
                @Override
                public Set<String> call() throws Exception {
                    return preOperation(E2);
                }
            });

            Future<Set<String>> LSet1 = completionService.take();
            Future<Set<String>> LSet2 = completionService.take();
            // 4. 计算相似度
            for (String L1 : LSet1.get()) {
                for (String L2 : LSet2.get()){
                    sim = Math.max(calSim(L1, L2), sim);
                }
            }


        }catch (Exception e){
            logger.error("匹配失败，抛出异常:",e);
        }
        logger.info(String.format("匹配成功,E1源方程:%s;E2目标方程:%s,相似度为:%s", E1, E2, sim));
        return sim;
    }

    /**
     * 双线程来处理
     * @param E 输入一个公式
     * @return
     */
    private Set<String> preOperation(String E){
        // 1.构造二叉树集合
        List<TreeNodeFunction> treeSet = new ArrayList<>();
        constructTreeSet(treeSet, E, E.length());

        // 2.归一化+找到结构可交换元素然后左右子树深度相同的节点 交换
        List<TreeNodeFunction> T = new ArrayList<>();
        for (TreeNodeFunction treeNodeFunction : treeSet) {
            normalization(treeNodeFunction);        // 归一化
            List<TreeNodeFunction> treeNodeFunctions = changeLeftAndRight(treeNodeFunction);    // 交换
            for (TreeNodeFunction nodeFunction : treeNodeFunctions) {
                T.add(nodeFunction);
            }
        }
        // 3.生成序列
        Set<String> LSet = new HashSet<>();
        for (TreeNodeFunction treeNodeFunction : T) {
            LSet.add(generateSequence(treeNodeFunction));
        }

        return LSet;
    }


    /**
     * 前序遍历二叉树
     */
    public static void pre(TreeNodeFunction root){
        if(root == null) return;
        System.out.println(root.getVal());
        pre(root.getLeftNode());
        pre(root.getRightNode());
    }

    /**
     *  1.构造二叉树集合  找到一个运算次序最低的元素符号 递归构造二叉树
     */
    public static TreeNodeFunction constructTreeSet(List<TreeNodeFunction> treeSet, String function,int length){
        if(findIndexOfFunction(function) == -1){  // 找到字符串中运算顺序最低的索引返回 -1说明是没有运算符号，只剩下元素符号
            return new TreeNodeFunction(function);
        }
        char opt = function.charAt(findIndexOfFunction(function)); // 运算符号

        TreeNodeFunction root = new TreeNodeFunction(String.valueOf(opt));

        for(int i = 0; i < function.length(); i++){
            if(function.charAt(i) == opt){
                root.setLeftNode(constructTreeSet(treeSet, function.substring(0, i), length));
                root.setRightNode(constructTreeSet(treeSet, function.substring(i + 1), length));
                if(function.length() == length){
                    treeSet.add(reconstruct(root));
                }
            }
        }
        return root;
    }

    /**
     * 2.先序遍历，如果该节点的val是OPS且左子树高度大于右子树
     * @param root
     */
    public static void normalization(TreeNodeFunction root){
        Stack<TreeNodeFunction> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                if(OPS.contains(root.getVal()) && findDepth(root.getLeftNode()) > findDepth(root.getRightNode())){
                    //交换左右子树
                    TreeNodeFunction temp = root.getRightNode();
                    root.setRightNode(root.getLeftNode());
                    root.setLeftNode(temp);
                }
                root = root.getLeftNode();
            }
            TreeNodeFunction node = stack.pop();
            root = node.getRightNode();
        }
    }

    /**
     * BFS找到子树的最大深度
     * @param root
     */
    public static int findDepth(TreeNodeFunction root){
        if(root == null) return 0;
        int depth = 0;
        Queue<TreeNodeFunction> queue = new LinkedList<TreeNodeFunction>(){{
            add(root);
        }};

        while(!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++){
                TreeNodeFunction node = queue.poll();

                if(node.getLeftNode() != null) queue.add(node.getLeftNode());
                if(node.getRightNode() != null) queue.add(node.getRightNode());
            }
            depth++;
        }

        return depth;
    }

    /**
     * 生成一个新的二叉树
     * @param pre
     * @return
     */
    public static TreeNodeFunction reconstruct(TreeNodeFunction pre){
        TreeNodeFunction res = new TreeNodeFunction(pre.getVal());
        Queue<TreeNodeFunction> queue = new LinkedList<>();
        Queue<TreeNodeFunction> queue2 = new LinkedList<>();
        queue.add(pre);
        queue2.add(res);

        while(!queue.isEmpty()){
            TreeNodeFunction node = queue.poll();
            TreeNodeFunction node2 = queue2.poll();

            if(node.getLeftNode() != null){
                node2.setLeftNode(new TreeNodeFunction(node.getLeftNode().getVal()));
                queue.add(node.getLeftNode());
                queue2.add(node2.getLeftNode());
            }

            if(node.getRightNode() != null){
                node2.setRightNode(new TreeNodeFunction(node.getRightNode().getVal()));
                queue.add(node.getRightNode());
                queue2.add(node2.getRightNode());
            }
        }
        return res;
    }
    // ernie 向量训练



    /**
     * 找到优先级最低的公式元素并返回索引 先不考虑括号 优先级升序:+,-,*,/
     * @return
     */
    public static int findIndexOfFunction(String function){
        int index = -1; //index为-1说明没有符号 是最后的一个元素

        if(function.contains("+")){
            for(int i = 0; i < function.length(); i++){
                char ch = function.charAt(i);
                if(ch == '+'){
                    index = i;
                    break;
                }
            }
        }else if(function.contains("-")){
            for(int i = 0; i < function.length(); i++){
                char ch = function.charAt(i);
                if(ch == '-'){
                    index = i;
                    break;
                }
            }
        }else if(function.contains("*")){
            for(int i = 0; i < function.length(); i++){
                char ch = function.charAt(i);
                if(ch == '*'){
                    index = i;
                    break;
                }
            }
        }else{
            for(int i = 0; i < function.length(); i++){
                char ch = function.charAt(i);
                if(ch == '/'){
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    /**
     * 找到符号相同的索引返回
     * @param function
     * @param sign
     * @return
     */
    public static int findSameSign(String function, char sign){
        if(function.contains(String.valueOf(sign))){
            for(int i = 0; i < function.length(); i++){
                if(function.charAt(i) == sign){
                    return i;
                }
            }
        }
        return -1; // -1 代表没有这个符号
    }

    /**
     *   3.找到结构可交换元素然后左右子树深度相同的节点 交换再生成二叉树 BFS
     */
    public static List<TreeNodeFunction> changeLeftAndRight(TreeNodeFunction root){
        if(root == null) return null;

        List<TreeNodeFunction> res = new ArrayList<TreeNodeFunction>(){{
            add(root);
        }};
        Queue<TreeNodeFunction> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNodeFunction node = queue.poll();
            if((node.getVal().equals("+") || node.getVal().equals("*")) && (findDepth(node.getLeftNode()) == findDepth(node.getRightNode()))){
                TreeNodeFunction temp = node.getLeftNode();
                node.setLeftNode(node.getRightNode());
                node.setRightNode(temp);
                res.add(reconstruct(root));
                temp = node.getLeftNode();
                node.setLeftNode(node.getRightNode());
                node.setRightNode(temp);

            }

            if(node.getLeftNode() != null){
                queue.add(node.getLeftNode());
            }
            if(node.getRightNode() != null){
                queue.add(node.getRightNode());
            }

        }
        return res;
    }


    /**
     * 4. 生成序列
     */

    public static String generateSequence(TreeNodeFunction root){
        String L = "";
        Stack<TreeNodeFunction> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                L += root.getVal().trim();
                root = root.getLeftNode();
            }
            root = stack.pop();
            root = root.getRightNode();
        }

        return L;
    }

    /**
     * 5. 计算相似度 取最大值
     */
    public static double calSim(String L1, String L2){

        int len = Math.min(L1.length(), L2.length());
        int sameNum = 0;
        for(int i = 0; i < len; i++){
            if(L1.charAt(i) == L2.charAt(i)){
                sameNum++;
            }
        }


        return (double)2 * sameNum / (L1.length() + L2.length());
    }


}
