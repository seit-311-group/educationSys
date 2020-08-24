package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.circuitQa;

import java.util.List;

public interface CircuitQAService {
    List<circuitQa> importQuestions();

    void updateQuestion(int id, String parentId, String childrenID);

}

