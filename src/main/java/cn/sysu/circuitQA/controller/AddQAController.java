package cn.sysu.circuitQA.controller;

import cn.sysu.circuitQA.service.AddQAService;
import cn.sysu.circuitQA.service.serviceImpl.AddQAServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 增加问题答案对页面 准备用Vue写
 * 需要用ajax来写 不然button已提交就会重载页面
 */
@RequestMapping("/addQA")
@Controller
public class AddQAController {
    @Autowired
    AddQAServiceImpl addQAService;

    @RequestMapping("/add")
    public String add(@RequestParam(value = "search", required = false) String search,
                      Model model){
        System.out.println(search);
        addQAService.pagingAndShow(search,model);
        return "addQA";
    }


}
