package cn.sysu.educationSys.utils;

import cn.sysu.educationSys.config.ConfigProperties;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

    @Autowired
    ConfigProperties configProperties;

    @Test
    public void postTest() throws Exception {
        String function1 = "a-a++c+b+a-1=1";
        String function2 = "a+b=0";
        HashMap<String, String> params = new HashMap<>();
        params.put("function1", function1);
        params.put("function2", function2);
        String paramString = JSON.toJSONString(params);
        String res = httpUtil.post("http://" + configProperties.getAlgorithmSeverIpAndPort() + "/functionMatch", paramString);
        JSONObject jsonObject = JSON.parseObject(res);
        System.out.println(jsonObject.get("similarity"));
        System.out.println(res);
    }

}
