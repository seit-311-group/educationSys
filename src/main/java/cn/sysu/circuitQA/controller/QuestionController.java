package cn.sysu.circuitQA.controller;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.service.CoreProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qa")
public class QuestionController {
    @Autowired
    private CoreProcessService coreProcess;

    @RequestMapping("/query")
    public String query(@RequestParam(value = "question") String question) throws Exception {
        circuitQa target =  coreProcess.analysis(question);
        return target.getAnswer();
    }

}