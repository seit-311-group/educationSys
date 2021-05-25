package cn.sysu.circuitQA.controller;


import cn.sysu.circuitQA.mapper.StudentMapperCustom;
import cn.sysu.circuitQA.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class PageIndexController {
    public static Long studentIdSave;

    @Autowired
    StudentMapperCustom studentMapperCustom;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("studentId")) {
                long studentId = Integer.parseInt(cookie.getValue());
                Student student = studentMapperCustom.findById(studentId);
                if (student != null){
                    //将id保存下来方便使用
                    studentIdSave = student.getId();
                    // 写到session中
                    request.getSession().setAttribute("studentName", student.getStudentname());
                    request.getSession().setAttribute("userId", student.getId());
                }
                break;
            }
        }
        return "main";
    }

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

    @RequestMapping("/feedback")
    public String feedback(){
        return "feedback";
    }

    @RequestMapping("/addQA")
    public String addQA(){
        return "addQA";
    }

    @RequestMapping("/answer")
    public String answer(){
        return "answer";
    }
}
