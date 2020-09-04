package cn.sysu.circuitQA;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.service.CircuitQAService;
import cn.sysu.circuitQA.service.CoreProcessService;
import cn.sysu.circuitQA.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProcessServiceTest {
    @Autowired
    private CoreProcessService coreProcessService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private cn.sysu.circuitQA.service.CircuitQAService CircuitQAService;

    @Test
    public void extractCandidatesTest() {
        List<circuitQa> candidates = coreProcessService.extractCandidates("什么是过渡过程？");
        if (candidates.size() == 0) {
            System.out.println("");
        }
        System.out.println(candidates.get(0));
        System.out.println(candidates.get(1));
    }
    @Test
    public void processTest() {
        questionService.process("什么是过渡过程？");
    }
    @Test
    public void subQueryTest() {
        System.out.println(coreProcessService.subQuery("什么是电路的过渡过程？"));}
    @Test
    public void getTest() {
        System.out.println(coreProcessService.getAnswerByOrder("2", "1.二阶电路中，过渡过程的性质取决于什么因素？" + "\n" + "2.什么是电路的过渡过程？" + "\n"));
    }
}
