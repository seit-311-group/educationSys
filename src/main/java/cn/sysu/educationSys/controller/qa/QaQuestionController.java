package cn.sysu.educationSys.controller.qa;

import cn.sysu.educationSys.mapper.QuestionRecordMapper;
import cn.sysu.educationSys.mapper.QuestionSpiderMapper;
import cn.sysu.educationSys.pojo.qa.QuestionSpider;
import cn.sysu.educationSys.pojo.qa.circuitQa;
import cn.sysu.educationSys.pojo.student.QuestionRecord;
import cn.sysu.educationSys.service.*;
import cn.sysu.educationSys.utils.HtmlParseUtil;
import cn.sysu.educationSys.utils.StaticVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.*;

@RestController
@RequestMapping("/qa")
public class QaQuestionController {
    private String spiderAnswer = null;
    private String queryFromStudent;

    @Autowired
    private CoreProcessService coreProcess;

    @Autowired
    RecordService recordService;

    @Autowired
    HtmlParseUtil htmlParseUtil;

    @Autowired
    QuestionSpiderMapper questionSpiderMapper;

    @Autowired
    KeywordtimesallService keywordtimesallService;

    @Autowired
    CircuitQAService circuitQAService;

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionRecordMapper questionRecordMapper;


    /**
     * 提取问题关键词保存、问题保存、匹配问题
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/query")
    public circuitQa query(@RequestParam(value = "question") String query) throws Exception {
        circuitQa target =  coreProcess.analysis(query);     //返回最佳问题
        recordService.wordsSave(query, target.getQuestion(), target.getAnswer());     // 保存query和question、answer对
        return target;
        // return target.getAnswer();
    }

    @RequestMapping("/querytop3")
    public String querytop3(@RequestParam(value = "question") String query) throws Exception {
        queryFromStudent = query;
        recordService.questionSave(query);
        return coreProcess.subQuestion(query);
    }


    /**
     * 问题爬虫 存在bug 百度知道网站爬不了
     * @param question
     * @return
     * @throws IOException
     */
    @RequestMapping("/questionSpider")
    public String questionSpider(@RequestParam(value = "question") String question) throws IOException {
        QuestionSpider questionSpider = htmlParseUtil.paraseQuetion(question);
        spiderAnswer = questionSpider.getAnswer();
        return spiderAnswer;
    }

    @RequestMapping("/subQuery")
    public String subQuery(@RequestParam(value = "question") String question) throws Exception {
        String questions = coreProcess.subQuery(question);
        if (questions.equals("")) {return StaticVariables.NO_SUBQUESTIONs;}
        return questions;
    }

    /**
     * bug 点完按钮 满意度反馈
     */
    @RequestMapping("/feedback")
    public void feedback(@RequestParam(value = "question") String question){
        QuestionSpider questionspider = new QuestionSpider();
        questionspider.setAnswer(spiderAnswer);
        questionspider.setQuestion(question);
        questionspider.setSatisfaction("不满意");
        questionSpiderMapper.insert(questionspider);
    }

    @RequestMapping("/feedback2")
    public String feedback2(@RequestBody QuestionSpider questionspider){
        questionspider.setQuestion(queryFromStudent);
        questionspider.setAnswer("无");
        questionSpiderMapper.insert(questionspider);
        return "提交成功，谢谢您的意见";
    }


    @GetMapping("/loadAllQuestions")
    public Map<String, List<String>> loadAllQuestions(){
        Map<String, List<String>> map = new HashMap<>();
        map.put("question", circuitQAService.findAllQuestions());
        return map;
    }


    /**
     * 对应于每一个a标签 用来找到这个问题的答案
     */
    @GetMapping("/findAnswerByQuestion")
    public String findAnswer(@RequestParam(value = "question") String question){
        return circuitQAService.findAnswerByQuestion(question);
    }

    /**
     * 上传图片功能
     * @param picture
     * @param studentId 学生的id
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("picture") MultipartFile[] picture, Long studentId, String description) {
        return questionService.upLoadPic(picture, studentId, description);
    }


}