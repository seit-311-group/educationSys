package cn.sysu.circuitQA.controller;

import cn.sysu.circuitQA.service.serviceImpl.AddQAServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 增加问题答案对页面 准备用Vue写
 * 需要用ajax来写 不然button已提交就会重载页面
 */
@RequestMapping("/addQA")
@Controller
public class AddQAController {
    @Autowired
    AddQAServiceImpl addQAService;

    /**
     * 搜索关键词
     * @param searchMap
     * @return 带有关键词的问题用@隔开
     */
    @ResponseBody
    @RequestMapping("/search")
    public String search(@RequestBody Map searchMap){
        String search = searchMap.get("search").toString();
        return addQAService.pagingAndShow(search);
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(@RequestBody Map addMap){
        String res = addQAService.addQA(addMap.get("res").toString());
        return res;
    }

}
