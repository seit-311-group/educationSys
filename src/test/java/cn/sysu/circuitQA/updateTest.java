package cn.sysu.circuitQA;

import cn.sysu.circuitQA.pojo.circuitQa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class updateTest {
    @Autowired
    private cn.sysu.circuitQA.service.CircuitQAService CircuitQAService;
//    @Autowired
//    private circuitQaMapper circuitQaMapper;
    @Test
    public void updateQuestionTest(){
        CircuitQAService.updateQuestion(1,"1 2","1");
    }
    @Test
    public void importQuestionTest(){
        List<circuitQa> questions = CircuitQAService.importQuestions();
        System.out.println(questions.get(0));
    }
}

