package cn.sysu.educationSys.service;

import cn.sysu.educationSys.mapper.StudentMapperCustom;
import cn.sysu.educationSys.pojo.student.Student;
import cn.sysu.educationSys.service.CookieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieSessionServiceImpl implements CookieSessionService {
    private String domain;

    @Autowired
    HttpServletResponse response;

    @Autowired
    HttpServletRequest request;

    @Autowired
    StudentMapperCustom studentMapperCustom;


    @Override
    public void addSession() {
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("studentId")) {
                long studentId = Long.parseLong(cookie.getValue());
                Student student = studentMapperCustom.findById(studentId);
                if (student != null){
                    // 写到session中
                    request.getSession().setAttribute("studentName", student.getStudentname());
                    request.getSession().setAttribute("userId", student.getId());
                }
                break;
            }
        }

        // Enumeration<String> attrs = request.getSession().getAttributeNames();
        // while(attrs.hasMoreElements()){
        //     String name = attrs.nextElement().toString();
        //     // 根据键值取session中的值
        //     Object vakue = request.getSession().getAttribute(name);
        //     // 打印结果
        //     System.out.println("------" + name + ":" + vakue +"--------\n");
        // }

    }

    @Override
    public void deleteCookie() {
        // 清除session 和 cookie
        request.getSession().removeAttribute("userId");
        Cookie cookie1 = new Cookie("studentId", null);
        cookie1.setMaxAge(0);
        cookie1.setDomain(domain);
        cookie1.setPath("/");
        response.addCookie(cookie1);
        Cookie cookie2 = new Cookie("JSESSIONID", null);
        cookie2.setMaxAge(0);
        cookie2.setDomain(domain);
        cookie2.setPath("/");
        response.addCookie(cookie2);
    }

    @Override
    public void addCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        // 通过设置domain、path可以获取到这个cookie，不加重定向后获取不到
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 返回域名
     * @param url
     * @return
     */
    @Override
    public void processUrl(String url) {
        String[] splits = url.split(":");
        domain = splits[1].substring(2);
    }

    @Override
    public Student findStudentByCookie(){
        Cookie[] cookies = request.getCookies();
        Student student = new Student();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("studentId")) {
                long studentId = Long.parseLong(cookie.getValue());
                student= studentMapperCustom.findById(studentId);
                break;
            }
        }
        return student;
    }


}
