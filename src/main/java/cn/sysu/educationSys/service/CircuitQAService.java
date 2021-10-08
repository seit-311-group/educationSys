package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.qa.circuitQa;

import java.util.List;
import java.util.Map;

public interface CircuitQAService {
    List<circuitQa> importQuestions();

    List<String> findAllQuestions();

    Map findIdByQuestion(String question, List<circuitQa> circuitQaList);

    void updateQuestion(int id, String childrenID, String parentId);

    circuitQa findQuestionById(String Id);

    String findAnswerByQuestion(String question);

}

