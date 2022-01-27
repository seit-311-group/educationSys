package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.answer.AnswerFunctionFeedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnswerFunctionRecordsServiceTest {
    @Autowired
    AnswerFunctionRecordsService answerFunctionRecordsService;

    @Test
    public void insertFeedbackTest(){
        AnswerFunctionFeedback answerFunctionFeedback = new AnswerFunctionFeedback();
        answerFunctionFeedback.setSubQuestionId(1);
        answerFunctionFeedback.setQuestionId(1);
        answerFunctionFeedback.setLatestFunction("testing");
        answerFunctionRecordsService.insertAnswerFunctionFeedback(answerFunctionFeedback);
    }

}
