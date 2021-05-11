package cn.sysu.circuitQA;

import cn.sysu.circuitQA.utils.ExtractUtil;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExtractTest {
    @Autowired
    ExtractUtil extractUtil;

    public static void main(String[] args) {
        System.out.println(ExtractUtil.extractAll("什么是基尔霍夫"));
    }

}
