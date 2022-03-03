package cn.sysu.educationSys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KeyWordServiceTest {
    @Autowired
    KeyWordService keyWordService;

    @Test
    public void test1() throws IOException {
        // List<String> res = keyWordService.getAnByQuestion("什么是节点分析法");
        // System.out.println(res);

    }
}
