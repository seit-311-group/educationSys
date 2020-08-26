package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.pojo.keyWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionProcessService {
    @Autowired
    private CircuitQAService circuitQAService;

    @Autowired
    private KeyWordService keyWordService;

    public List<circuitQa> extractCandidates(String question) {
        List<circuitQa> circuitQas = circuitQAService.importQuestions();
        List<keyWord> keyWords = keyWordService.importKeyWords();
        String keyword = extract(question);
        List<circuitQa> candidates = new ArrayList<circuitQa>();
        for (keyWord word : keyWords) {
            if (keyword == word.getKeyword()){
                String ids = word.getQuestionids();
                String[] IDs = ids.split(",");
                for (String ID : IDs) {
                    for (circuitQa Qa : circuitQas) {
                        if (String.valueOf(Qa.getQuestionid()) == ID){
                            candidates.add(Qa);
                        }
                    }
                }
                break;
            }
        }
        return candidates;
    }
    private String extract(String question) {
        return
    }
}
