package cn.sysu.circuitQA.controller;


import cn.sysu.circuitQA.pojo.Student;
import cn.sysu.circuitQA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Printable;

/**
 * 现存问题：1.学生登录后自己的页面，自己的信息。
 *          2.登录前点击问答系统，答题系统时不能跳转，要先登录注册。
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @RequestMapping("/loginStatus")
    public String loginStatus(Student student) {
        return studentService.login(student);
    }

    @RequestMapping("/registStatus")
    public String registStatus(Student student){
        return studentService.regist(student);
    }

}
