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

    @RequestMapping("/subQuery")
    public String subQuery(@RequestParam(value = "question") String question) throws Exception {
        String questions = coreProcess.subQuery(question);
        if (questions.equals("")) {return "";}
        return questions;
    }

    @RequestMapping("/getAnswerByOrder")
    public String getAnswerByOrder(@RequestParam(value = "order") String order, @RequestParam(value = "questions") String questions ) throws Exception {
        String target =  coreProcess.getAnswerByOrder(order, questions);
        return target;
    }
}