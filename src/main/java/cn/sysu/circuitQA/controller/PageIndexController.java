package cn.sysu.circuitQA.controller;

import cn.sysu.circuitQA.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageIndexController {

    @RequestMapping("/")
    public String index() {return "main";}

    @RequestMapping("/systemQA")
    public String systemQA() {return "index";}

    @RequestMapping("/student/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/student/regist")
    public String regist() {
        return "regist";
    }

}
