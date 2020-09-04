package cn.sysu.circuitQA;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.pojo.keyWord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KeyWordServiceTest {
    @Autowired
    private cn.sysu.circuitQA.service.KeyWordService keyWordService;

    @Test
    public void getIDByKeyWordTest(){
        System.out.println(keyWordService.getIDByKeyWord("过渡过程"));
    }
    @Test
    public void importKeyWordsTest(){
        List<keyWord> keyWords = keyWordService.importKeyWords();
        System.out.println(keyWords.get(0));
    }
}
