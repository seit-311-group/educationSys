package cn.sysu.educationSys.utils;

import cn.sysu.educationSys.pojo.qa.circuitQa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchUtilTest {
    @Autowired
    MatchUtil matchUtil;

    @Test
    public void deepLearningTest() throws Exception {
        String question = "什么是戴维南";

        Map<circuitQa, Float> map = new HashMap<>();
        List<circuitQa> candidates = new ArrayList<>();
        circuitQa circuitQa1 = new circuitQa();
        circuitQa1.setQuestion("戴维南定理适用范围");
        circuitQa circuitQa2 = new circuitQa();
        circuitQa2.setQuestion("直流电路中的分析方法是否适用于交流电路");
        circuitQa circuitQa3 = new circuitQa();
        circuitQa3.setQuestion("戴维南定理和诺顿定理中受控源该如何处理");
        candidates.add(circuitQa1);
        candidates.add(circuitQa2);
        candidates.add(circuitQa3);

        // System.out.println(matchUtil.matchWithDeepLearning(map, candidates, question));
    }
}
