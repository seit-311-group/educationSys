package cn.sysu.educationSys.service.serviceImpl;


import cn.sysu.educationSys.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
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
}
