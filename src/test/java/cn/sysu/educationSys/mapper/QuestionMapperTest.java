package cn.sysu.educationSys.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QuestionMapperTest {
    @Autowired
    questionMapper questionMapper;

    @Test
    public void findSubQuestionById(){
        String subQuestionIdByQuestionId = questionMapper.findSubQuestionIdByQuestionId(1);
        System.out.println(subQuestionIdByQuestionId);
    }

}
