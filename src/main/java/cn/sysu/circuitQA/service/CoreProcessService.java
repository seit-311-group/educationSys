package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.pojo.keyWord;
import cn.sysu.circuitQA.service.CircuitQAService;
import cn.sysu.circuitQA.service.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CoreProcessService {

    @Autowired
    private CircuitQAService circuitQAService;

    @Autowired
    private KeyWordService keyWordService;

    private List<circuitQa> circuitQas;

    private List<keyWord> keyWords;

    private Map<String, circuitQa> questionMap;

    /**
     *
     * @param query
     * @return 匹配到的qa对象
     */
    public circuitQa analysis(String query) {

        System.out.println("原始问句：" + query);

        List<circuitQa> candidates = extractCandidates(query);
        if (candidates.isEmpty()) {return null;}
        System.out.println("候选问题集：");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println(String.valueOf(i) + " " + candidates.get(i).getQuestion());
        }

        circuitQa target = questionMatch(candidates, query);
        System.out.println("匹配结果：" + target);

        return target;
    }
    //提取候选问题集
    public List<circuitQa> extractCandidates(String question) {
        this.circuitQas = circuitQAService.importQuestions();
        this.keyWords = keyWordService.importKeyWords();
        this.questionMap = new HashMap<String, circuitQa>();
        for (circuitQa ques : circuitQas) {
            questionMap.put(String.valueOf(ques.getQuestionid()), ques);
        }
        String keyword = extract(question);
        if (keyword == "") {
            return null;
        }
        List<circuitQa> candidates = new ArrayList<circuitQa>();
        for (keyWord word : keyWords) {
            if (keyword == word.getKeyword()){
                String ids = word.getQuestionids();
                String[] IDs = ids.split(",");
                for (String ID : IDs) {
                    candidates.add(questionMap.get(ID));
                }
                break;
            }
        }
        return candidates;
    }
    //提取关键词
    private String extract(String question) {
        //测试的本方法的时候可以取消注释，并把方法改为public
        //if (keyWords == null) {this.keyWords = keyWordService.importKeyWords();}
        String word = "";
        try {
            for (keyWord keyword : keyWords) {
                if (question.indexOf(keyword.getKeyword()) > -1) {
                    word = keyword.getKeyword();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return word;
    }
    //相似度匹配
    private circuitQa questionMatch(List<circuitQa> candidates, String query) {
        circuitQa target = candidates.get(0);
        float similarity = levenshtein(query, target.getQuestion());
        for (circuitQa candidate : candidates) {
            float new_similarity = levenshtein(query, candidate.getQuestion());
            if (new_similarity > similarity) {
                target = candidate;
                similarity = new_similarity;
            }
        }
        return target;
    }
    //相似度计算
    private float levenshtein(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dif = new int[len1 + 1][len2 + 1];
        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,
                        dif[i - 1][j] + 1);
            }
        }
        float similarity =1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
        return similarity;
    }

    private int min(int... is) {
        int min = Integer.MAX_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    /**
     *
     * @param ques
     * @return 所有衍生问题内容
     */
    public String subQuery(String ques) {
        circuitQa qa = analysis(ques);
        String[] childIDs = qa.getChildid().split(" ");
        circuitQa[] childQuestions = new circuitQa[childIDs.length];

        String res = "";
        for (int i = 0; i < childQuestions.length; i++) {
            circuitQa question = questionMap.get(childIDs[i]);
            res = res + String.valueOf(i+1) + "." + question.getQuestion() + "\n";
        }
        return res;
    }

    public String getAnswerByOrder(String order, String questions) {
        circuitQas = circuitQAService.importQuestions();
        String[] qas = questions.split("\n");
        String target = "";
        for (String question : qas) {
            if (question.substring(0,1).equals(order)) {
                target =  question.substring(2);
            }
        }
        System.out.println(target);
        for (circuitQa qa : circuitQas) {
            if (qa.getQuestion().equals(target)) {
                return qa.getAnswer();
            }
        }
        return "";
    }
}
