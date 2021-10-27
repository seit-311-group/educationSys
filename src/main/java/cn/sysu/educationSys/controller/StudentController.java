package cn.sysu.educationSys.controller;


import cn.sysu.educationSys.mapper.StudentMapperCustom;
import cn.sysu.educationSys.pojo.student.Student;
import cn.sysu.educationSys.service.CookieSessionService;
import cn.sysu.educationSys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

    @Autowired
    CookieSessionService cookieSessionService;

    @Autowired
    HttpServletRequest request;

    /**
     * 登录 加入redis！！
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
            cookieSessionService.addCookie("studentId", studentId);
            studentMapperCustom.insertLoginRecord(id); // 登录进去之后有一条记录  之后学redis的时候可以先缓存到redis中
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
            cookieSessionService.addCookie("studentId", studentId);
            studentMapperCustom.insertLoginRecord(id); // 登录进去之后有一条记录
            studentMapperCustom.insertRegisterRecord(id); // 注册进去之后有一条记录
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
        cookieSessionService.deleteCookie();
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping("/findAllPassedQuestion")
    public String[] findAllPassedQuestion(){
        return studentService.findPassedQuestion(cookieSessionService.findStudentByCookie().getId());
    }

    // GET     用来获取资源，
    // POST    用来新建资源（也可以用于更新资源），
    // PUT     用来更新资源，
    // DELETE  用来删除资源
    @ResponseBody
    @RequestMapping("/saveErrorPoints")
    public void saveErrorPoints(@RequestParam(value = "points") String points){
        studentService.saveQuestionIdPointIdAndPassedQuestion(points);
    }


    @ResponseBody
    @RequestMapping("/checkUserExist")
    public String checkUserExist(@RequestParam(value = "id") Long id){
        if(studentMapperCustom.findById(id) == null){
            return "用户不存在";
        }else{
            return "用户存在";
        }
    }




}
