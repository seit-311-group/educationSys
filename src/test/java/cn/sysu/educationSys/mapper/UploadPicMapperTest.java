package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.qa.UploadPic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UploadPicMapperTest {
    @Autowired
    UploadPicMapper uploadPicMapper;

    @Test
    public void TestInsert(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        uploadPicMapper.insertUpload(new UploadPic(1001200L, "asd", "adasd", timestamp));
    }
}
