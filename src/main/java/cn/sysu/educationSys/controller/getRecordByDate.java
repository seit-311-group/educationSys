package cn.sysu.educationSys.controller;

import cn.sysu.educationSys.service.CookieSessionService;
import cn.sysu.educationSys.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class getRecordByDate {
    @Autowired
    RecordService recordService;

    @Autowired
    CookieSessionService cookieSessionService;

    @Autowired
    HttpServletRequest request;

    //实现分页显示表功能

    /**
     * 搜多的时候分页有bug
     * @param model
     * @param pageNumber
     * @param search
     * @return
     */
    @RequestMapping("/record")
    public String record(@RequestParam(value = "pageNumber", required = false) String pageNumber,
                         @RequestParam(value = "search", required = false)String search,
                         Model model
                         ){

        recordService.pagingAndShow(search, pageNumber, model);
        return "qa_record";
    }
}
