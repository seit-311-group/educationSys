package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.circuitQa;

import java.util.List;
import java.util.Map;

public interface CircuitQAService {
    List<circuitQa> importQuestions();

    Map findIdByQuestion(String question, List<circuitQa> circuitQaList);

    void updateQuestion(int id, String childrenID, String parentId);

    circuitQa findQuestionById(String Id);

}

