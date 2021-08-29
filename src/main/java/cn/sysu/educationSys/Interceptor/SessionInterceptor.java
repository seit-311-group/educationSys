package cn.sysu.educationSys.Interceptor;

import cn.sysu.educationSys.service.CookieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    CookieSessionService cookieSessionService;

    @Override//在一个请求进入Controller层方法执行前执行这个方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在这里可以对参数做一些预处理和做一些验证
        cookieSessionService.addSession();
        return true;//方法给予执行，就是允许controller的方法进行执行
        //false 不允许，可以在这之前在reponse中编写返回的结果

    }
    //返回model前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //Controller执行完毕后，返回之前，可以对request和reponse进行处理
        //如果是前后端没有分离，在进入View层中前执行
    }

    //返回model后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //在一个请求处理完毕，即将销毁的时候，执行，可以做一些资源释放之类的工作
    }
}
