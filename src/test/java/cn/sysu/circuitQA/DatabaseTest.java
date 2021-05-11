package cn.sysu.circuitQA;


import cn.sysu.circuitQA.mapper.*;
import cn.sysu.circuitQA.pojo.Keywordtimesall;
import cn.sysu.circuitQA.pojo.Questionspider;
import cn.sysu.circuitQA.service.KeywordtimesallService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DatabaseTest {
    @Autowired
    private RecordMapperCustom recordMapperCustom;

    @Autowired
    QuestionspiderMapper questionspiderMapper;

    @Autowired
    KeywordtimesallService keywordtimesallService;

    @Autowired
    KeywordtimesallMapperCustom keywordtimesallMapperCustom;

    @Autowired
    StudentMapperCustom studentMapperCustom;

    @Test
    public void getQuestions() {
        // List<String> allQuestion = recordMapperCustom.getAllQuery();
        // System.out.println(allQuestion);
        //     Questionspider questionspider = new Questionspider();
        //     // questionspider.setQuestion("asdsadasd");
        //     questionspiderMapper.insert(questionspider);
        // }
        // keywordtimesallService.kgUpdate("电路",1);
        // List<String> allKeywords = keywordtimesallMapperCustom.getAllKeywords();
        // for(String s : allKeywords){
        //     System.out.println(s);
        // }
        System.out.println(studentMapperCustom.findById((long)11));
    }

}
