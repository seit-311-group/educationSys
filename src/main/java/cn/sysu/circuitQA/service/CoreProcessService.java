package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.pojo.keyWord;
import cn.sysu.circuitQA.utils.MatchUtil;
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
    private KeyWordService keyWordService;

    // @Autowired
    // private RecordService recordService;

    private List<circuitQa> circuitQas;

    private List<keyWord> keyWords;

    private Map<String, circuitQa> questionMap; //id对应问题对象

//    private Map<keyword, id>

    {
        NLPTokenizer.ANALYZER.enableCustomDictionary(true);
    }


    /**
     *
     * @param query
     * @return 匹配到的qa对象
     */
    public circuitQa analysis(String query) throws IOException {
        logger.info("原始问句：" + query);

        List<circuitQa> candidates = null;
        try {
            candidates = extractCandidates(query);
        } catch (Exception e) {
            logger.error("没有相关问题");
        }
        if (candidates == null) {
            logger.info("没有候选问题集！");
            circuitQa targetNull = new circuitQa();
            targetNull.setQuestion("没有匹配到该问题");
            targetNull.setAnswer("没有匹配到该答案");
            return targetNull;
        }
        logger.info("候选问题集：");
        for (int i = 0; i < candidates.size(); i++) {
            logger.info(i + " " + candidates.get(i).getQuestion());
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
    //提取候选问题集
    public List<circuitQa> extractCandidates(String question) {
        this.circuitQas = circuitQAService.importQuestions();
        System.out.println("数据库中有" + circuitQas.size() + "个问题答案对");
        keyWords = keyWordService.importKeyWords();
        System.out.println("数据库中有" + keyWords.size() + "个关键词");
        this.questionMap = new HashMap<String, circuitQa>();
        for (circuitQa ques : circuitQas) {
            questionMap.put(String.valueOf(ques.getQuestionid()), ques);
        }
//        String keyword = ExtractUtil.extract(question);
        String keyword = extract(question);
        if (keyword == "") {
            return null;
        }
        List<circuitQa> candidates = new ArrayList<circuitQa>();
        for (keyWord word : keyWords) {
            if (keyword.equals(word.getKeyword())){
                String ids = word.getQuestionids();
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
    //提取关键词
    public String extract(String question) {
        String word = "";
        List<Term> seg = NLPTokenizer.segment(question);
        try {
            for (Term term : seg) {
                for (keyWord keyword : keyWords) {
                    if (term.word.equals(keyword.getKeyword())) {
                        word = keyword.getKeyword();
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
     *
     * @param ques
     * @return 查找子问题
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

    public String getAnswerByOrder(String order, String questions) {
        if (questions == null || questions.length() == 0) {
            return "";
        }
        try {
            circuitQas = circuitQAService.importQuestions();
            String[] qas = questions.split("@");
            String target = qas[Integer.parseInt(order)];
            logger.info("后续提问：" + target);
            for (circuitQa qa : circuitQas) {
                if (qa.getQuestion().equals(target)) {
                    return qa.getAnswer();
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "输入错误，请重新输入！";
        }
        return "";
    }
}
