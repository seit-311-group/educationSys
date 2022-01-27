package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.answer.AnswerFunctionFeedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnswerFunctionFeedbackMapperTest {
    @Autowired
    AnswerFunctionFeedbackMapper answerFunctionFeedbackMapper;

    @Test
    public void insertTest1(){
        AnswerFunctionFeedback answerFunctionFeedback = new AnswerFunctionFeedback();
        answerFunctionFeedbackMapper.insertFeedback(answerFunctionFeedback);
    }

}
