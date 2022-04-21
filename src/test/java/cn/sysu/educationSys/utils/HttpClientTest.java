package cn.sysu.educationSys.utils;

import cn.sysu.educationSys.config.ConfigProperties;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


    @Test
    public void textMatchingTest() throws Exception {
        String question = "什么是戴维南";
        List<String> candidate = new ArrayList<String>() {{
            add("戴维南定理适用范围？");
            add("直流电路中的分析方法是否适用于交流电路？为什么？");
            add("戴维南定理和诺顿定理中受控源该如何处理？");
            add("戴维南定理是什么？");
        }};

        JSONObject request = new JSONObject();
        request.put("question", question);
        request.put("candidate", candidate);

        String res = httpUtil.post("http://" + configProperties.getAlgorithmSeverIpAndPort() + "/textMatch", request.toJSONString());
        JSONObject jsonObject = JSON.parseObject(res);
        System.out.println(jsonObject);
    }

}
