package cn.sysu.educationSys.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConfigPropertiesTest {
    @Autowired
    ConfigProperties configProperties;

    @Test
    public void testConfig(){
        System.out.println(configProperties.getAlgorithmSeverIpAndPort());
    }
}
