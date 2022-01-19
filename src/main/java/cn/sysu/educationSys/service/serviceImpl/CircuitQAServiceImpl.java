package cn.sysu.educationSys.service.serviceImpl;

import cn.sysu.educationSys.pojo.qa.circuitQa;
import cn.sysu.educationSys.pojo.qa.circuitQaExample;
import cn.sysu.educationSys.service.CircuitQAService;
import cn.sysu.educationSys.service.RecordService;
import cn.sysu.educationSys.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CircuitQAServiceImpl implements CircuitQAService {
    @Autowired
    private cn.sysu.educationSys.mapper.circuitQaMapper circuitQaMapper;

    @Autowired
    private RecordService recordService;

    @Autowired
    HttpUtil httpUtil;


    //@Scheduled(cron="0 0 2 * * ?") 定时运行一次
    @Override
    public List<circuitQa> importQuestions() {
        circuitQaExample circuitQaExample = new circuitQaExample();
        return circuitQaMapper.selectByExample(circuitQaExample);
    }

    @Override
    public List<String> findAllQuestions() {
        List<circuitQa> circuitQas = importQuestions();
        List<String> list = new ArrayList<>();
        for (circuitQa circuitQa : circuitQas) {
            list.add(circuitQa.getQuestion());
        }
        return list;
    }

    /**
     * 通过问题寻找该问题的父子节点
     * @param question
     * @return {questionId=490, childId=172 199 306, parentId=263 261}
     */
    @Override
    public Map findIdByQuestion(String question, List<circuitQa> circuitQaList) {
        HashMap<String, String> map = new HashMap<>();
        circuitQaList.forEach(circuitQa -> {
            if(circuitQa.getQuestion().equals(question)){
                map.put("questionId", String.valueOf(circuitQa.getQuestionid()));
                map.put("childId", circuitQa.getChildid());
                map.put("parentId", circuitQa.getParentid());
            }
        });
        return map;
    }

    @Override
    public void updateQuestion(int id, String childrenID, String parentId) {
        circuitQa record = new circuitQa();
        record.setChildid(childrenID);
        record.setParentid(parentId);
        circuitQaExample circuitQaExample = new circuitQaExample();
        circuitQaExample.Criteria criteria = circuitQaExample.createCriteria();
        criteria.andQuestionidEqualTo(id);
        circuitQaMapper.updateByExampleSelective(record, circuitQaExample);
    }

    @Override
    public circuitQa findQuestionById(String Id) {
        List<circuitQa> circuitQaList = importQuestions();
        circuitQa circuitQa = new circuitQa();
        for (circuitQa qa : circuitQaList) {
            if (String.valueOf(qa.getQuestionid()).equals(Id)){
                circuitQa = qa;
            }
        }
        return circuitQa;
    }

    @Override
    public String findAnswerByQuestion(String question) {
        String answerByQuestion = circuitQaMapper.findAnswerByQuestion(question);
        recordService.wordsSave(question, question, answerByQuestion);

        return answerByQuestion;
    }

    /**
     * 首先找到这个小题对应的方程 然后调用httpUtil来计算相似度
     * @param function
     * @return
     */
    @Override
    public String calFunctionSimilarity(String function) {
        String function1 = function;
        String function2 = "a + b + c";
        // 调用公式匹配Api
        HashMap<String, String> params = new HashMap<>();
        params.put("function1", function1);
        params.put("function2", function2);
        String paramString = JSON.toJSONString(params);
        JSONObject res = JSON.parseObject(httpUtil.post("http://172.18.219.212:5000/functionMatch", paramString));
        double similarity = Double.parseDouble(res.get("similarity").toString());
        String fun1Simplify = String.valueOf(res.get("function1"));
        String fun2Simplify = (String) res.get("function2");
        System.out.println(Math.round(similarity * 100) + "%");
        if (similarity == 1){

        }else{

        }

        return fun1Simplify;
    }
}

