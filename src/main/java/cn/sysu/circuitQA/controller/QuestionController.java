package cn.sysu.circuitQA.controller;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.service.CoreProcessService;
import cn.sysu.circuitQA.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/qa")
public class QuestionController {
    @Autowired
    private CoreProcessService coreProcess;

    @Autowired
    RecordService recordService;

    @RequestMapping("/query")
    public String query(@RequestParam(value = "question") String question) throws Exception {
        circuitQa target =  coreProcess.analysis(question);
        System.out.println(recordService.wordsSave(question));
        return target.getAnswer();
    }

    @RequestMapping("/subQuery")
    public String subQuery(@RequestParam(value = "question") String question) throws Exception {
        String questions = coreProcess.subQuery(question);
        return questions;
    }

    @RequestMapping("/getAnswerByOrder")
    public String getAnswerByOrder(@RequestParam(value = "order") String order, @RequestParam(value = "questions") String questions ) throws Exception {
        String target =  coreProcess.getAnswerByOrder(order, questions);
        return target;
    }
}