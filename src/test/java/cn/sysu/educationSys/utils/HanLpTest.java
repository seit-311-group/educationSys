package cn.sysu.educationSys.utils;

import com.hankcs.hanlp.HanLP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HanLpTest {
    @Test
    public void extraKeyWordTest(){
        List<String> keywordList = HanLP.extractKeyword("谁是杨老师", 5);
        System.out.println(keywordList);
    }
}
