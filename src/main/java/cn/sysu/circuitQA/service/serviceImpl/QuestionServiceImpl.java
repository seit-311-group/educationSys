package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.service.CoreProcessService;
import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.service.CircuitQAService;
import cn.sysu.circuitQA.service.KeyWordService;
import cn.sysu.circuitQA.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private CircuitQAService circuitQAService;

    @Autowired
    private KeyWordService keyWordService;

    @Autowired
    private CoreProcessService coreProcess;

    public void process(String query) {
        circuitQa target = coreProcess.analysis(query);
        System.out.println(target.getAnswer());
        coreProcess.subQuery(query);
    }

}
