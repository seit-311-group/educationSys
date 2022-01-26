package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.answer.AnswerFunctionRecords;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnswerFunctionRecordsMapperTest {
    @Autowired
    AnswerFunctionRecordsMapper answerFunctionRecordsMapper;

    @Test
    public void insertTest(){
        AnswerFunctionRecords answerFunctionRecords = new AnswerFunctionRecords("test", "test", "test", "test", 1.0, 1313, new Timestamp(new Date().getTime()), 1, 1);
        answerFunctionRecordsMapper.insertAnswerFunctionRecords(answerFunctionRecords);
    }
}
