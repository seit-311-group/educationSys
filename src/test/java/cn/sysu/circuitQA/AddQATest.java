package cn.sysu.circuitQA;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.service.AddQAService;
import cn.sysu.circuitQA.service.CircuitQAService;
import cn.sysu.circuitQA.service.CoreProcessService;
import cn.sysu.circuitQA.service.KeyWordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static cn.sysu.circuitQA.service.serviceImpl.AddQAServiceImpl.circuitQaList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddQATest {
    @Autowired
    AddQAService addQAService;

    @Autowired
    CircuitQAService circuitQAService;

    @Autowired
    CoreProcessService coreProcessService;

    @Autowired
    KeyWordService keyWordService;

    @Test
    public void test1(){
        String s = addQAService.addQA("fa@test1,fa@test2,question@什么是电路3,answer@由金属导线和电气、电子部件组成的导电回路，称为电路。在电路输入端加上电源使输入端产生电势差，电路连通时即可工作。,");
        System.out.println(s);
    }

    @Test
    public void test2(){
        Map map = circuitQAService.findIdByQuestion("test1",circuitQaList);     //{questionId=93, childId=, parentId=}
        System.out.println(map);
        circuitQa questionById = circuitQAService.findQuestionById("498");
        System.out.println(questionById.getQuestion());

    }

    @Test
    public void test3(){
        addQAService.addKeyword("什么是电路", "497");
    }
}
