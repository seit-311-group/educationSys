package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.Student;

public interface CookieSessionService {
    void addSession();

    void deleteCookie();

    void addCookie(String name, String value);

    void processUrl(String url);

    Student findStudentByCookie();
}
