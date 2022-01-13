package cn.sysu.educationSys.utils;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HttpClientTest {
    @Autowired
    HttpUtil httpUtil;

    @Test
    public void postTest(){
        String function1 = "a-a++c+b+a-1=1";
        String function2 = "a+b=0";
        HashMap<String, String> params = new HashMap<>();
        params.put("function1", function1);
        params.put("function2", function2);
        String paramString = JSON.toJSONString(params);
        String res = httpUtil.post("http://172.18.219.212:5000/functionMatch", paramString);
        System.out.println(res);
    }

}
