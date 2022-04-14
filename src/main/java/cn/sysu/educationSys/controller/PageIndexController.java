package cn.sysu.educationSys.controller;


import cn.sysu.educationSys.mapper.StudentMapperCustom;
import cn.sysu.educationSys.pojo.qa.question;
import cn.sysu.educationSys.service.CookieSessionService;
import cn.sysu.educationSys.service.QuestionService;
import cn.sysu.educationSys.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class PageIndexController {
    @Autowired
    StudentMapperCustom studentMapperCustom;

    @Autowired
    RecordService recordService;

    @Autowired
    QuestionService questionService;

    @Autowired
    CookieSessionService cookieSessionService;

    @RequestMapping("/")
    public String index() {
        return "qa/qa_system";
    }

    @ResponseBody
    @RequestMapping("/getUrl")
    public void getUrl(@RequestBody Map map){
        cookieSessionService.processUrl(map.get("url").toString());
    }

    @RequestMapping("/systemQA")
    public String systemQA() {

        // cookieSessionService.addSession();
        return "qa/qa_system";}

    @RequestMapping("/student/login")
    public String login() {
        return "login_sign_up";
    }

    @RequestMapping("/student/regist")
    public String regist() {
        return "regist";
    }

    @RequestMapping("/feedback")
    public String feedback(){
        // studentIdSave = cookieSessionService.addSession();
        return "qa/qa_feedback";
    }

    @RequestMapping("/addQA")
    public String addQA(){
        // cookieSessionService.addSession();
        return "qa/qa_add_qa";
    }

    @RequestMapping("/feedbackTwoSys")
    public String feedbackTwoSys(){
        return "feedbackTwoSys";
    }

    @RequestMapping("/homepage")
    public String homepage(){
        return "homepage";
    }

    @RequestMapping("/answer_index")
    public String answerIndex(){
        // // test 先加上cookie
        // Cookie cookie1 = new Cookie("studentId", "1");
        // cookie1.setDomain("localhost");
        // cookie1.setPath("/");
        // response.addCookie(cookie1);
        // // test 正式使用时注解掉

        cookieSessionService.addSession();
        return "answer/answer_index";
    }

    @RequestMapping("/question")
    public String question(){
        return "answer/answer_question";
    }

    @ResponseBody
    @RequestMapping("/load")
    public List<question> load(){
        return questionService.findAll();
    }

    /**
     * 找到问答记录 并返回页面
     * @param model
     * @param pageNumber
     * @param search
     * @return
     */
    @RequestMapping("/record")
    public String record(@RequestParam(value = "pageNumber", required = false) String pageNumber,
                         @RequestParam(value = "search", required = false)String search,
                         Model model
    ){

        recordService.pagingAndShow(search, pageNumber, model);
        return "qa/qa_record";
    }

}
