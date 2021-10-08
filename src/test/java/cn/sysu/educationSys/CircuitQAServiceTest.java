package cn.sysu.educationSys;

import cn.sysu.educationSys.pojo.qa.circuitQa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CircuitQAServiceTest {
    @Autowired
    private cn.sysu.educationSys.service.CircuitQAService circuitQAService;

    @Test
    public void questionTest() {
        List<circuitQa> list= circuitQAService.importQuestions();
        for (circuitQa circuitQa : list) {
            System.out.println(circuitQa.getQuestion());
        }
        // circuitQa qa= list.get(2);
        // System.out.println("是啥"+qa.getChildid());
        // System.out.println(qa.getChildid().equals(" "));
        // System.out.println("".equals(null));
        // System.out.println(qa.getChildid().equals("\\N"));
    }

}
