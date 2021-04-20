package cn.sysu.circuitQA;


import cn.sysu.circuitQA.mapper.RecordMapperCustom;
import cn.sysu.circuitQA.mapper.StudentMapperCustom;
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

    @Test
    public void getQuestions(){
        List<String> allQuestion = recordMapperCustom.getAllQuery();
        System.out.println(allQuestion);
    }

}
