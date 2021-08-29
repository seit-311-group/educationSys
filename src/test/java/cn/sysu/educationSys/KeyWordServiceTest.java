package cn.sysu.educationSys;

import cn.sysu.educationSys.pojo.keyWord;
import cn.sysu.educationSys.service.CoreProcessService;
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
    private cn.sysu.educationSys.service.KeyWordService keyWordService;

    @Autowired
    CoreProcessService coreProcessService;

    @Test
    public void getIDByKeyWordTest(){
        System.out.println(keyWordService.getIDByKeyWord("过渡过程"));
    }
    @Test
    public void importKeyWordsTest(){
        List<keyWord> keyWords = keyWordService.importKeyWords();
        System.out.println(keyWords.get(0));
    }

    @Test
    public void keyword(){
        List<keyWord> keyWords = keyWordService.importKeyWords();
        String s = coreProcessService.extract("什么是戴维南定理");
        System.out.println(s);
    }
}
