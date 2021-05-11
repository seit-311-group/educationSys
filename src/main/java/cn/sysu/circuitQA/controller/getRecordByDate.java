package cn.sysu.circuitQA.controller;

import cn.sysu.circuitQA.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class getRecordByDate {
    @Autowired
    RecordService recordService;

    //实现分页显示表功能

    /**
     * 搜多的时候分页有bug
     * @param model
     * @param pageNumber
     * @param search
     * @return
     */
    @RequestMapping("/record")
    public String record(Model model,
                         @RequestParam(value = "pageNumber", required = false) String pageNumber,
                         @RequestParam(value = "search", required = false)String search
                         ){
        recordService.pagingAndShow(search, pageNumber, model);
        return "recordStudent";
    }
}
