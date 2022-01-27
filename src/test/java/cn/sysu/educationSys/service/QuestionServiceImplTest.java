package cn.sysu.educationSys.service;


import cn.sysu.educationSys.service.serviceImpl.QuestionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QuestionServiceImplTest {
    @Autowired
    QuestionServiceImpl questionService;

    @Test
    public void testValue(){
        // questionService.testConfigurationProperties();
    }

    @Test
    public void isListEquationTest(){
        System.out.println(questionService.isListEquation("14"));
    }

    @Test
    public void findRightFunctionTest(){
        System.out.println(questionService.findRightFunction("15"));
    }
}
