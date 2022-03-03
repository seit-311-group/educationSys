package cn.sysu.educationSys.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KeyWordMapperTest {
    @Autowired
    keyWordMapper keyWordMapper;

    @Test
    public void getAnByKeyword(){
        String 换路定律 = keyWordMapper.getAnByKeyWord("节点法");
        System.out.println(换路定律);
    }

}
