package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.answer.AnswerFunctionFeedback;
import cn.sysu.educationSys.pojo.answer.AnswerFunctionRecords;

public interface AnswerFunctionRecordsService {
    public void insertAnswerFunctionRecords(AnswerFunctionRecords answerFunctionRecords);

    public void insertAnswerFunctionFeedback(AnswerFunctionFeedback answerFunctionFeedback);
}
