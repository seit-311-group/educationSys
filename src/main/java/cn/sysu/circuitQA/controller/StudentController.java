package cn.sysu.circuitQA.controller;


import cn.sysu.circuitQA.pojo.Student;
import cn.sysu.circuitQA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Printable;

/**
 * 现存问题：1.学生登录后自己的页面，自己的信息。
 *          2.登录前点击问答系统，答题系统时不能跳转，要先登录注册。
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/loginCallBack")
    public String loginCallback(Student student,HttpServletRequest request){
        String studentName = studentService.login(student);
        if (studentName != null) {
            // 登陆成功，写cookie和session
            request.getSession().setAttribute("studentName", studentName);
            return "redirect:/";
        }else {
            // 登陆失败，重新登录
            return "redirect:/student/login";
        }
    }

    @RequestMapping("/registCallBack")
    public String registCallback(Student student,HttpServletRequest request){
        String studentName = studentService.regist(student);
        if (studentName != null) {
            // 注册成功，写cookie和session
            request.getSession().setAttribute("studentName", studentName);
            return "redirect:/";
        }else {
            // 注册失败，重新注册
            return "redirect:/student/regist";
        }
    }

}
