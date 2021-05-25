package cn.sysu.circuitQA.controller;


import cn.sysu.circuitQA.mapper.StudentMapperCustom;
import cn.sysu.circuitQA.pojo.Student;
import cn.sysu.circuitQA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentMapperCustom studentMapperCustom;

    @Autowired      // HttpServletRequest request 写到形参自动注入
    HttpServletResponse response;

    /**
     * 登录
     * @param id
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/loginCallBack")
    public String loginCallback(@RequestParam(value = "id") Long id,
                                @RequestParam(value = "password") String password){
        Student studentExist = studentService.login(id, password);
        if (studentExist != null) {
            // 登陆成功，在页面上添加一个cookie
            String studentId = studentExist.getId().toString();
            Cookie cookie = new Cookie("studentId", studentId);
            // 通过设置domain、path可以获取到这个cookie，不加重定向后获取不到
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);
            return "登陆成功";
        }else {
            // 登陆失败，重新登录
            return "学号或密码错误，请重新登录！";
        }
    }

    /**
     * ajax传入 传入json对象不方便
     * @param id
     * @param name
     * @param password
     * @param classandgrade
     * @return
     */
    @ResponseBody
    @RequestMapping("/registCallBack")
    public String registCallback(@RequestParam(value = "id") Long id,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "classandgrade") String classandgrade
                                 ){
        Student studentExist = studentService.regist(id,name,password,classandgrade);
        if (studentExist != null) {
            // 注册成功，在页面上添加一个cookie
            String studentId = studentExist.getId().toString();
            Cookie cookie = new Cookie("studentId", studentId);
            // 通过设置domain、path可以获取到这个cookie，不加重定向后获取不到
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);
            return "注册成功";
        }else {
            // 注册失败，重新注册
            return "用户存在，注册失败，请重新注册";
        }
    }


    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
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
