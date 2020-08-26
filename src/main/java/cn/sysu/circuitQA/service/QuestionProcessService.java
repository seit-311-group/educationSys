package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.pojo.keyWord;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionProcessService {
    @Autowired
    private CircuitQAService circuitQAService;

    @Autowired
    private KeyWordService keyWordService;

    private List<circuitQa> circuitQas;

    private List<keyWord> keyWords;

    public List<circuitQa> extractCandidates(String question) {
        this.circuitQas = circuitQAService.importQuestions();
        this.keyWords = keyWordService.importKeyWords();
        Map<String, circuitQa> questionMap = new HashMap<String, circuitQa>();
        for (circuitQa ques : circuitQas) {
            questionMap.put(String.valueOf(ques.getQuestionid()), ques);
        }
        String keyword = extract(question);
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
}
