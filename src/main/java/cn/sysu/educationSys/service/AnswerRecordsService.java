package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.AnswerRecords;

import java.util.List;

public interface AnswerRecordsService {
    void insertRecord(AnswerRecords answerRecords);

    List<AnswerRecords> findRecordsByStudentId(Long studentId,String questionId);

    String getAllPoints(String result);

    int countRecordsByQuestionId(String questionId);
}
