package cn.sysu.educationSys.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FunctionSimUtilTest {
    @Autowired
    FunctionSimUtil functionSimUtil;

    @Test
    public void test1(){
        System.out.println(functionSimUtil.calSimilarity("a * b + a + b + c", "b * a + b + a + c"));
    }
}
