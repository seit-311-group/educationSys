package cn.sysu.educationSys.service;

import cn.sysu.educationSys.mapper.AnswerFunctionFeedbackMapper;
import cn.sysu.educationSys.mapper.AnswerFunctionRecordsMapper;
import cn.sysu.educationSys.pojo.answer.AnswerFunctionFeedback;
import cn.sysu.educationSys.pojo.answer.AnswerFunctionRecords;
import cn.sysu.educationSys.service.AnswerFunctionRecordsService;
import cn.sysu.educationSys.service.CookieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerFunctionRecordsServiceImpl implements AnswerFunctionRecordsService {
    @Autowired
    AnswerFunctionRecordsMapper answerFunctionRecordsMapper;

    @Autowired
    AnswerFunctionFeedbackMapper answerFunctionFeedbackMapper;

    @Autowired
    CookieSessionService cookieSessionService;

    @Override
    public void insertAnswerFunctionRecords(AnswerFunctionRecords answerFunctionRecords) {
        answerFunctionRecordsMapper.insertAnswerFunctionRecords(answerFunctionRecords);
    }

    @Override
    public void insertAnswerFunctionFeedback(AnswerFunctionFeedback answerFunctionFeedback) {
        answerFunctionFeedback.setStudentId(cookieSessionService.findStudentByCookie().getId());
        answerFunctionFeedbackMapper.insertFeedback(answerFunctionFeedback);
    }
}
