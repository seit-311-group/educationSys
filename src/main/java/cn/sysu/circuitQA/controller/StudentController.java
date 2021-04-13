package cn.sysu.circuitQA.controller;


import cn.sysu.circuitQA.mapper.StudentMapper;
import cn.sysu.circuitQA.pojo.Student;
import cn.sysu.circuitQA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 现存问题：1.学生登录后自己的页面，自己的信息。
 *          2.登录前点击问答系统，答题系统时不能跳转，要先登录注册。
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("/loginCallBack")                                                           // HttpServletRequest request 写到形参自动注入
    public String loginCallback(Student student, HttpServletResponse response){                  // HttpServletResponse response
        Student studentExist = studentService.login(student);
        if (studentExist != null) {
            // 登陆成功，在页面上添加一个cookie
            String studentId = studentExist.getId().toString();
            Cookie cookie = new Cookie("studentId", studentId);
            // 通过设置domain、path可以获取到这个cookie，不加重定向后获取不到
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/";
        }else {
            // 登陆失败，重新登录
            return "redirect:/student/login";
        }
    }

    @RequestMapping("/registCallBack")
    public String registCallback(Student student,HttpServletRequest request,
                                 HttpServletResponse response){
        Student studentExist = studentService.regist(student);
        if (studentExist != null) {
            // 注册成功，在页面上添加一个cookie
            String studentId = studentExist.getId().toString();
            Cookie cookie = new Cookie("studentId", studentId);
            // 通过设置domain、path可以获取到这个cookie，不加重定向后获取不到
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);
            return "/";
        }else {
            // 注册失败，重新注册
            return "redirect:/student/regist";
        }
    }

    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request,
                         HttpServletResponse response){
        // 清除session 和 cookie
        request.getSession().removeAttribute("userId");
        Cookie cookie1 = new Cookie("studentId", null);
        cookie1.setMaxAge(0);
        cookie1.setDomain("localhost");
        cookie1.setPath("/");
        response.addCookie(cookie1);
        Cookie cookie2 = new Cookie("JSESSIONID", null);
        cookie2.setMaxAge(0);
        cookie2.setDomain("localhost");
        cookie2.setPath("/");
        response.addCookie(cookie2);
        return "redirect:/";
    }


}
