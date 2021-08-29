package cn.sysu.educationSys;

import cn.sysu.educationSys.pojo.circuitQa;
import cn.sysu.educationSys.service.CoreProcessService;
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

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProcessServiceTest {
    @Autowired
    private CoreProcessService coreProcessService;

    @Autowired
    StudentService studentService;

    @Autowired
    private cn.sysu.educationSys.service.CircuitQAService CircuitQAService;

    @Test
    public void extractCandidatesTest() {
        List<circuitQa> candidates = coreProcessService.extractCandidates("什么是换路定律？");
        if (candidates.size() == 0) {
            System.out.println("没有候选问题");
        }
        System.out.println(candidates.get(0));
        System.out.println(candidates.get(1));
    }

    @Test
    public void analysis1Test() throws IOException {
        List<circuitQa> list = coreProcessService.analysisTop3("什么是戴维南定理");
        list.forEach(System.out::println);
    }

    @Test
    public void matchTest(){
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
        List<circuitQa> list = MatchUtil.matchTop3(candidate, "什么是戴维南定理");
        for (circuitQa circuit: list){
            System.out.println(circuit.getQuestion());
        }
    }

    @Test
    public void subQueryTest() throws IOException, InterruptedException {
        System.out.println(coreProcessService.subQuery("电导和电阻表示元件的什么特性？"));}
    @Test
    public void getTest() {
        System.out.println(coreProcessService.getAnswerByOrder("2", "RL一阶电路的阶跃响应（t=0时接入电源），流过电感的电流如何变化？.二阶电路在单位阶跃响应中曲线变化情况是怎样的？.处理RC电路、RL电路阶跃响应的关键"));
    }
    @Test
    public void orderTest() throws IOException, InterruptedException {
        System.out.println(coreProcessService.getAnswerByOrder("0", coreProcessService.subQuery("什么是阶跃响应")));
    }

    @Test
    public void test1(){
        studentService.updateQueryKeywords((long)1, "wiwiid");
        // String a = "";
        // System.out.println(a == null);
    }
}
