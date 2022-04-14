package cn.sysu.educationSys.controller;

import cn.sysu.educationSys.service.CookieSessionService;
import cn.sysu.educationSys.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/feedbackTwoSys")
public class FeedBackController {

    @Autowired
    FeedBackService feedBackService;

    @Autowired
    CookieSessionService cookieSessionService;

    /**
     * 反馈功能
     * @param feedback
     */
    @RequestMapping("/submit")
    public void submit(@RequestBody Map feedback){
        feedBackService.insert(feedback.get("feedback").toString(),cookieSessionService.findStudentByCookie().getId());
    }
}
