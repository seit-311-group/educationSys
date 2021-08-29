package cn.sysu.educationSys.service.serviceImpl;

import cn.sysu.educationSys.pojo.circuitQa;
import cn.sysu.educationSys.pojo.circuitQaExample;
import cn.sysu.educationSys.service.CircuitQAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CircuitQAServiceImpl implements CircuitQAService {
    @Autowired
    private cn.sysu.educationSys.mapper.circuitQaMapper circuitQaMapper;

    //@Scheduled(cron="0 0 2 * * ?") 定时运行一次
    @Override
    public List<circuitQa> importQuestions() {
        circuitQaExample circuitQaExample = new circuitQaExample();
        return circuitQaMapper.selectByExample(circuitQaExample);
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
}

