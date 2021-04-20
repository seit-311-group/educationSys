package cn.sysu.circuitQA.controller;

import cn.sysu.circuitQA.CircuitQA;
import cn.sysu.circuitQA.pojo.Questionspider;
import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.service.CoreProcessService;
import cn.sysu.circuitQA.service.RecordService;
import cn.sysu.circuitQA.utils.HtmlParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/qa")
public class QuestionController {
    @Autowired
    private CoreProcessService coreProcess;

    @Autowired
    RecordService recordService;

    @Autowired
    HtmlParseUtil htmlParseUtil;

    @RequestMapping("/query")
    public String query(@RequestParam(value = "question") String query) throws Exception {
        circuitQa target =  coreProcess.analysis(query);
        recordService.wordsSave(query, target.getQuestion(), target.getAnswer());     // 保存query和question、answer对
        System.out.println(target.getAnswer());
        return target.getAnswer();
    }

    /**
     * 问题爬虫 存在bug 百度知道网站爬不了
     * @param question
     * @return
     * @throws IOException
     */
    @RequestMapping("/questionSpider")
    public String questionSpider(@RequestParam(value = "question") String question) throws IOException {
        Questionspider questionspider = htmlParseUtil.paraseQuetion(question);
        return questionspider.getAnswer();
    }

    @RequestMapping("/subQuery")
    public String subQuery(@RequestParam(value = "question") String question) throws Exception {
        String questions = coreProcess.subQuery(question);
        if (questions.equals("")) {return "";}
        return questions;
    }

    @RequestMapping("/getAnswerByOrder")
    public String getAnswerByOrder(@RequestParam(value = "order") String order, @RequestParam(value = "questions") String questions ) throws Exception {
        String target =  coreProcess.getAnswerByOrder(order, questions);
        return target;
    }

    @RequestMapping("/feedback")
    public String feedback(){
        return "";
    }

    // @RequestMapping("/addMessage")
    // public void addMessage(@RequestParam(value = "message") String message) throws Exception {
    //     Date now = new Date();
    //     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    //     String nowDate = format.format(now);
    //     MessageService.addMessage(message, nowDate);
    // }
    //
    // @RequestMapping("/getRecordByDate")
    // public String getRecordByDate(@RequestParam(value = "fromdate") String date) throws Exception {
    //     Date now = new Date();
    //     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    //     String nowDate = format.format(now);
    //     if (date.length() != 8 || Integer.parseInt(date) > Integer.parseInt(nowDate)){
    //         return "请输入正确的日期";
    //     }
    //     return RecordService.findRecord(date);
    // }

//    @RequestMapping("/upload")
//    public String uploadFile(MultipartFile mFile) throws IOException {
//        String fileName = mFile.getOriginalFilename();
//        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
//        String path = "C:\\fileUpload\\" + fileName;
//        File dest = new File(path);
//
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdir();
//        }
//        try {
//
//            mFile.transferTo(dest); //保存文件
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "留言";
//    }


}