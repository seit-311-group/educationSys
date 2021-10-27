package cn.sysu.educationSys.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentTest {
    @Autowired
    StudentMapperCustom studentMapperCustom;

    public static void main(String[] args) {

    }


    @Test
    public void LoginRecordTest(){
        studentMapperCustom.insertRegisterRecord(1232222L);
    }
}
