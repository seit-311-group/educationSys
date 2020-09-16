package cn.sysu.circuitQA;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.service.CoreProcessService;
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
    public void subQueryTest() {
        System.out.println(coreProcessService.subQuery("什么是电路的过渡过程？"));}
    @Test
    public void getTest() {
        System.out.println(coreProcessService.getAnswerByOrder("2", "RL一阶电路的阶跃响应（t=0时接入电源），流过电感的电流如何变化？.二阶电路在单位阶跃响应中曲线变化情况是怎样的？.处理RC电路、RL电路阶跃响应的关键"));
    }
    @Test
    public void orderTest() {
        System.out.println(coreProcessService.getAnswerByOrder("0", coreProcessService.subQuery("什么是阶跃响应")));
    }
}
