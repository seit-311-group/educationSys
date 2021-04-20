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

    @Autowired
    StudentMapperCustom studentMapperCustom;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            // equals和==有区别 “==”比较的是两个引用的对象是否相等，而equals()方法比较的是两个对象的实际内容
            if (cookie.getName().equals("studentId")) {
                long studentId = Integer.parseInt(cookie.getValue());
                Student student = studentMapperCustom.findById(studentId);
                if (student != null){
                    // 写到session中
                    request.getSession().setAttribute("studentName",student.getStudentname());
                    request.getSession().setAttribute("userId", student.getId());
                }
                break;
            }
        }
        return "main";}

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

    public String index() {return "index";}


}
