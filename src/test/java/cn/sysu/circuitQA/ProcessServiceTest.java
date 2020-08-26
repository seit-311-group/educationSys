package cn.sysu.circuitQA;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.service.QuestionProcessService;
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
    private QuestionProcessService questionProcessService;

    @Test
    public void extractCandidatesTest() {
        List<circuitQa> candidates = questionProcessService.extractCandidates("什么是过渡过程？");
        if (candidates.size() == 0) {
            System.out.println("");
        }
        System.out.println(candidates.get(0));
    }
//    @Test
//    public void extractTest() {
//        System.out.println(questionProcessService.extract("什么是过渡过程？"));
//    }
}
