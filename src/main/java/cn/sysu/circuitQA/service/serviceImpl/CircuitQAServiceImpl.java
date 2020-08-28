package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.mapper.circuitQaMapper;
import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.pojo.circuitQaExample;
import cn.sysu.circuitQA.service.CircuitQAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitQAServiceImpl implements CircuitQAService {
    @Autowired
    private cn.sysu.circuitQA.mapper.circuitQaMapper circuitQaMapper;

    //@Scheduled(cron="0 0 2 * * ?")
    @Override
    public List<circuitQa> importQuestions() {
        circuitQaExample circuitQaExample = new circuitQaExample();
        circuitQaExample.Criteria criteria = circuitQaExample.createCriteria();
        return circuitQaMapper.selectByExample(circuitQaExample);
    }
    @Override
    public void updateQuestion(int id, String parentId, String childrenID) {
        circuitQa record = new circuitQa();
        record.setChildid(childrenID);
        record.setParentid(parentId);
        circuitQaExample circuitQaExample = new circuitQaExample();
        circuitQaExample.Criteria criteria = circuitQaExample.createCriteria();
        criteria.andQuestionidEqualTo(id);
        circuitQaMapper.updateByExampleSelective(record, circuitQaExample);
    }
}

