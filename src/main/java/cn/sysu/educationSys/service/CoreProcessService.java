package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.qa.circuitQa;
import cn.sysu.educationSys.pojo.qa.keyWord;
import cn.sysu.educationSys.utils.MatchUtil;
import cn.sysu.educationSys.utils.StaticVariables;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class CoreProcessService {
    private static Logger logger = Logger.getLogger(CoreProcessService.class);

    @Autowired
    private CircuitQAService circuitQAService;

    @Autowired
    private KeywordtimesallService keywordtimesallService;

    @Autowired
    private KeyWordService keyWordService;

    @Autowired
    StudentService studentService;
    // @Autowired
    // private RecordService recordService;

    @Autowired
    CookieSessionService cookieSessionService;

    @Autowired
    RecordService recordService;

    private List<circuitQa> circuitQas;

    public static List<keyWord> keyWords;

    private Map<String, circuitQa> questionMap; //id对应问题对象

//    private Map<keyword, id>

    {
        NLPTokenizer.ANALYZER.enableCustomDictionary(true);
    }


    /**
     * 找到最佳问题返回
     * @param query
     * @return 匹配到的qa对象
     */
    public circuitQa analysis(String query) throws IOException {
        logger.info("原始问句：" + query);

        List<circuitQa> candidates = null;
        try {
            candidates = extractCandidates(query);      // 提取关键词，找到候选问题集
        } catch (Exception e) {
            logger.error("没有相关问题");
        }
        if (candidates == null) {
            recordService.wordsSave(query, "没有找到该问题", "没有找到该问题");
            logger.info("没有候选问题集！");
            circuitQa targetNull = new circuitQa();
            targetNull.setQuestion("没有匹配到该问题");
            targetNull.setAnswer("没有匹配到该答案");
            return targetNull;
        }
        logger.info("候选问题集：");
        for (int i = 0; i < candidates.size(); i++) {
            logger.info(i + " " + candidates.get(i).getQuestion());  // 打印候选问题集
        }
        circuitQa target = null;
        try {
//            target = MatchUtil.matchByRPC(candidates, query);
            target = MatchUtil.match1(candidates, query);
            logger.info("匹配结果：" + target.getQuestion());
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                logger.error("gRPC通信故障");
            } else{
                logger.error("没有匹配到你的问题");
            }
        }
        return target;
    }


    /**
     * 找到三个最佳的问题返回
     * @param query
     * @return
     * @throws IOException
     */
    public Map<circuitQa, Float> analysisTop5(String query) throws IOException {
        logger.info("原始问句：" + query);

        List<circuitQa> candidates = null;
        List<String> targerList = new ArrayList<>();
        try {
            candidates = extractCandidates(query);      // 提取关键词，找到候选问题集
        } catch (Exception e) {
            logger.error("没有相关问题");
        }
        if (candidates == null) {
            recordService.wordsSave(query, "没有找到该问题", "没有找到该问题");
            logger.info("没有候选问题集！");
            List<circuitQa> targetNull = new ArrayList<>();
            circuitQa target = new circuitQa();
            target.setQuestion("没有匹配到该问题");
            target.setAnswer("没有匹配到该答案");
            targetNull.add(target);
            return null;
        }
        logger.info("候选问题集：");
        for (int i = 0; i < candidates.size(); i++) {
            logger.info(i + " " + candidates.get(i).getQuestion());  // 打印候选问题集
        }
        Map<circuitQa, Float> target = new LinkedHashMap<>();
        try {
//            target = MatchUtil.matchByRPC(candidates, query);
            target = MatchUtil.matchTop5(candidates,query); // 找到最佳的五个问题
            int index = 1;
            for (Map.Entry<circuitQa, Float> circuitQaFloatEntry : target.entrySet()){
                logger.info("匹配结果：" + index++ + circuitQaFloatEntry.getKey().getQuestion());
                targerList.add(circuitQaFloatEntry.getKey().getQuestion());
            }

        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                logger.error("gRPC通信故障");
            } else{
                logger.error("没有匹配到你的问题");
            }
        }
        return target;
    }

    /**
     * 通过关键词，找出问题中所有包含该关键词的问题，即提取候选问题集
     * @param question
     * @return
     */
    public List<circuitQa> extractCandidates(String question) {
        this.circuitQas = circuitQAService.importQuestions();
        System.out.println("数据库中有" + circuitQas.size() + "个问题答案对");
        this.questionMap = new HashMap<>();
        for (circuitQa ques : circuitQas) {
            questionMap.put(String.valueOf(ques.getQuestionid()), ques);        // id:question
        }
//        String keyword = ExtractUtil.extract(question);
        String keyword = extract(question);     // 提取关键词
        if (keyword.equals("")) {
            return null;
        }
        List<circuitQa> candidates = new ArrayList<>();
        for (keyWord word : keyWords) {     // 遍历所有关键词
            if (keyword.equals(word.getKeyword())){     // equals中写对象
                String ids = word.getQuestionids();   // 找到问题的id
                String[] IDs = ids.split(",");
                for (String ID : IDs) {
                    if (questionMap.containsKey(ID)) {
                        candidates.add(questionMap.get(ID));
                    } else {
                        logger.error("问题表里没有这个ID："+ID+",属于关键词"+keyword);
                    }
                }
                break;
            }
        }
        return candidates;
    }


    /**
     * 提取关键词
     * @param question
     * @return 关键词
     */
    public String extract(String question) {
        this.keyWords = keyWordService.importKeyWords();
        System.out.println("数据库中有" + keyWords.size() + "个关键词");
        String word = "";
        List<Term> seg = NLPTokenizer.segment(question);        //分词
        System.out.println(seg);
        try {
            for (Term term : seg) {
                for (keyWord keyword : keyWords) {
                    if (term.word.equals(keyword.getKeyword())) {
                        word = keyword.getKeyword();
                        // 把提取出来的关键词加到学生自己的querykeywords中
                        studentService.updateQueryKeywords(cookieSessionService.findStudentByCookie().getId(), word);
                        keywordtimesallService.keywordInsertOrUpdate(word);                  // 保存关键词和次数到表中

                        logger.info("关键词：" + word);
                        return word;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return word;
    }



    /**
     *  查找子问题
     * @param ques
     * @return
     */
    public String subQuery(String ques) throws IOException, InterruptedException {
        circuitQa qa = analysis(ques);
        if((qa == null) || qa.getChildid().length() == 0) {return "";}
        String[] childIDs = qa.getChildid().split(" ");
        List<String> childIDList = Arrays.asList(childIDs);
        List childIDlist = new ArrayList(childIDList);
//        if (childIDlist.size() <= 2) { # 与KG通信
//            String keyword = extract(ques);
//            String[] words = KGUtil.extend(keyword);
//            for (String word:words) {
//                String ids = keyWordService.getIDByKeyWord(word);
//                if (ids != null) {
//                    String[] IDs = ids.split(",");
//                    for (String ID : IDs) {
//                        childIDlist.add(ID);
//                    }
//                } else {
//                    continue;
//                }
//                if (childIDlist.size() == 3) {
//                    break;
//                }
//            }
//        }

        String res = "";
        for (int i = 0; i < childIDlist.size(); i++) {
            circuitQa question = null;
            try {
                question = questionMap.get(childIDlist.get(i));
                res = res + "@" + question.getQuestion();
            } catch (Exception e) {
                continue;
            }

        }
        return (res.length() == 0) ? null : res.substring(1);
    }

    /**
     * 拼接好问题给用户选择
     * @return
     */
    public String subQuestion(String query) throws IOException {
        Map<circuitQa, Float> circuitQaFloatMap = analysisTop5(query);  // 返回排序好的map
        String questionList = "";
        if (circuitQaFloatMap == null){
            return StaticVariables.QUESTION_MISMATCHED;
        }else{
            // 判断相似度最高的问题达到直接返回答案的阈值
            for (Map.Entry<circuitQa, Float> circuitQaFloatEntry : circuitQaFloatMap.entrySet()) {
                if(circuitQaFloatEntry.getValue() >= StaticVariables.SIMILARITY_MATCHING_THRESHOLD){
                    recordService.wordsSave(query, circuitQaFloatEntry.getKey().getQuestion(), circuitQaFloatEntry.getKey().getAnswer());
                    return StaticVariables.DIRECT_ANSWER + circuitQaFloatEntry.getKey().getAnswer();
                }else if(circuitQaFloatEntry.getValue() < StaticVariables.MISMATCHED_THRESHOLD){
                    recordService.wordsSave(query, "没有找到该问题", "没有找到该问题");
                    return StaticVariables.QUESTION_MISMATCHED;
                }
                break;
            }
        }

        for (Map.Entry<circuitQa, Float> circuitQaFloatEntry : circuitQaFloatMap.entrySet()) {
            questionList = questionList + "@" + circuitQaFloatEntry.getKey().getQuestion();
        }

        return questionList.substring(1);
    }


}
