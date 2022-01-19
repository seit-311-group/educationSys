package cn.sysu.educationSys.service.serviceImpl;

import cn.sysu.educationSys.service.CircuitQAService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CircuitQAServiceImplTest extends TestCase {
    @Autowired
    CircuitQAService circuitQAService;



    @Test
    public void test(){
        System.out.println(circuitQAService.findAnswerByQuestion("什么是电路的过渡过程？"));
    }

    @Test
    public void test1(){
        circuitQAService.calFunctionSimilarity("a+b+c+1=0");
    }

}