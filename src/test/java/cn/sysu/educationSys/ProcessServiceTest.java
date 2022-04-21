package cn.sysu.educationSys;

import cn.sysu.educationSys.pojo.qa.circuitQa;
import cn.sysu.educationSys.service.serviceImpl.CoreProcessServiceImpl;
import cn.sysu.educationSys.service.StudentService;
import cn.sysu.educationSys.utils.MatchUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProcessServiceTest {
    @Autowired
    private CoreProcessServiceImpl coreProcessServiceImpl;

    @Autowired
    StudentService studentService;

    @Autowired
    MatchUtil matchUtil;

    @Autowired
    private cn.sysu.educationSys.service.CircuitQAService CircuitQAService;

    @Test
    public void extractCandidatesTest() throws IOException {
        List<circuitQa> candidates = coreProcessServiceImpl.extractCandidates("什么是换路定律？");
        if (candidates.size() == 0) {
            System.out.println("没有候选问题");
        }
        System.out.println(candidates.get(0));
        System.out.println(candidates.get(1));
    }

    @Test
    public void analysis1Test() throws IOException {
        Map<circuitQa, Float> circuitQaFloatMap = coreProcessServiceImpl.analysisTop5("什么是戴维南定理");
        // list.forEach(System.out::println);
        System.out.println(circuitQaFloatMap);
    }

    @Test
    public void subQuestionTest() throws IOException {
        System.out.println(coreProcessServiceImpl.subQuestion("213123"));
    }

    @Test
    public void matchTest() throws Exception {
        List<circuitQa> candidate = new ArrayList<>();
        circuitQa circuitQa1 = new circuitQa();
        circuitQa circuitQa2 = new circuitQa();
        circuitQa circuitQa3 = new circuitQa();
        circuitQa circuitQa4 = new circuitQa();
        circuitQa1.setQuestion("戴维南定理适用范围？");
        circuitQa2.setQuestion("戴维南定理和诺顿定理在多频电路中应注意？");
        circuitQa3.setQuestion("频域的戴维南定理和诺顿定理与相量域的区别是什么？");
        circuitQa4.setQuestion("戴维南定理和诺顿定理中受控源该如何处理？");
        candidate.add(circuitQa1);
        candidate.add(circuitQa2);
        candidate.add(circuitQa3);
        candidate.add(circuitQa4);
        Map<circuitQa, Float> 什么是戴维南定理 = matchUtil.matchTop5(candidate, "什么是戴维南定理");
        // for (circuitQa circuit: list){
        //     System.out.println(circuit.getQuestion());
        // }
    }

    @Test
    public void subQueryTest() throws IOException, InterruptedException {
        System.out.println(coreProcessServiceImpl.subQuery("电导和电阻表示元件的什么特性？"));}

    @Test
    public void test1(){
        studentService.updateQueryKeywords((long)1, "wiwiid");
        // String a = "";
        // System.out.println(a == null);
    }
}
