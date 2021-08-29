package cn.sysu.educationSys.controller;


import cn.sysu.educationSys.mapper.StudentMapperCustom;
import cn.sysu.educationSys.pojo.question;
import cn.sysu.educationSys.service.CookieSessionService;
import cn.sysu.educationSys.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class PageIndexController {
    @Autowired
    StudentMapperCustom studentMapperCustom;

    @Autowired
    QuestionService questionService;

    @Autowired
    CookieSessionService cookieSessionService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/getUrl")
    public void getUrl(@RequestBody Map map){
        cookieSessionService.processUrl(map.get("url").toString());
    }

    @RequestMapping("/systemQA")
    public String systemQA() {

        // cookieSessionService.addSession();
        return "qa_index";}

    @RequestMapping("/student/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/student/regist")
    public String regist() {
        return "regist";
    }

    @RequestMapping("/feedback")
    public String feedback(){
        // studentIdSave = cookieSessionService.addSession();
        return "qa_feedback";
    }

    @RequestMapping("/addQA")
    public String addQA(){
        // cookieSessionService.addSession();
        return "qa_add_qa";
    }

    @RequestMapping("/feedbackTwoSys")
    public String feedbackTwoSys(){
        return "feedbackTwoSys";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
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
        return "answer_index";
    }

    @RequestMapping("/question")
    public String question(){
        return "answer_question";
    }

    @ResponseBody
    @RequestMapping("/load")
    public List<question> load(){
        return questionService.findAll();
    }

}
