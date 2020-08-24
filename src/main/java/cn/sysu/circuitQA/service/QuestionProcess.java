package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.circuitQa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionProcess {
    @Autowired
    private CircuitQAService circuitQAService;

    public List<circuitQa> extractCandidates(String question) {
        List<circuitQa> questions = circuitQAService.importQuestions();
        return
    }
}
