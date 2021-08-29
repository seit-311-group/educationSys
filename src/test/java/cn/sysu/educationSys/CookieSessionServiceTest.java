package cn.sysu.educationSys;

import cn.sysu.educationSys.service.CookieSessionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CookieSessionServiceTest {
    @Autowired
    CookieSessionService cookieSessionService;

    @Test
    public void processUrlTest(){
        // String s = cookieSessionService.processUrl("http://localhost:8080/");
        // System.out.println(s);
    }

    @Test
    public void cookieAddTest(){
        cookieSessionService.addCookie("woshi", "你爹");
    }

}
