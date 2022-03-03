package cn.sysu.educationSys.service;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CoreProcessServiceTest {
    @Autowired
    CoreProcessService coreProcessService;

    @Test
    public void extraTest(){
        List<Term> seg = NLPTokenizer.segment("什么是电路");
        System.out.println(seg);
    }
}
