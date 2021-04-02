package cn.sysu.circuitQA.controller;

import cn.sysu.circuitQA.mapper.RecordMapper;
import cn.sysu.circuitQA.pojo.Record;
import cn.sysu.circuitQA.service.RecordService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.awt.print.Printable;
import java.util.List;

@Controller
public class getRecordByDate {

    @Autowired
    RecordMapper recordMapper;

    @RequestMapping("/record")
    public String record(Model model){
        List<Record> records =recordMapper.findAll();
        model.addAttribute("records",records);
        return "record";
    }


}
