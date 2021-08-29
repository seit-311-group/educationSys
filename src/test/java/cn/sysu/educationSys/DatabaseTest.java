package cn.sysu.educationSys;


import cn.sysu.educationSys.mapper.*;
import cn.sysu.educationSys.service.KeywordtimesallService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DatabaseTest {
    @Autowired
    private RecordMapperCustom recordMapperCustom;

    @Autowired
    QuestionSpiderMapper questionSpiderMapper;

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
