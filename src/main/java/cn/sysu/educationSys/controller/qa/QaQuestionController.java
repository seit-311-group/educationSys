package cn.sysu.educationSys.controller.qa;

import cn.sysu.educationSys.mapper.QuestionSpiderMapper;
import cn.sysu.educationSys.pojo.QuestionSpider;
import cn.sysu.educationSys.pojo.circuitQa;
import cn.sysu.educationSys.service.CircuitQAService;
import cn.sysu.educationSys.service.CoreProcessService;
import cn.sysu.educationSys.service.KeywordtimesallService;
import cn.sysu.educationSys.service.RecordService;
import cn.sysu.educationSys.utils.HtmlParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.sysu.educationSys.service.CoreProcessService.keywordSave;


@RestController
@RequestMapping("/qa")
public class QaQuestionController {
    private String spiderAnswer = null;
    private String queryFromStudent;

    @Autowired
    private CoreProcessService coreProcess;

    @Autowired
    RecordService recordService;

    @Autowired
    HtmlParseUtil htmlParseUtil;

    @Autowired
    QuestionSpiderMapper questionSpiderMapper;

    @Autowired
    KeywordtimesallService keywordtimesallService;

    @Autowired
    CircuitQAService circuitQAService;


    /**
     * 提取问题关键词保存、问题保存、匹配问题
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/query")
    public circuitQa query(@RequestParam(value = "question") String query) throws Exception {
        circuitQa target =  coreProcess.analysis(query);     //返回最佳问题
        recordService.wordsSave(query, target.getQuestion(), target.getAnswer());     // 保存query和question、answer对
        keywordtimesallService.keywordInsertOrUpdate(keywordSave);                  // 保存关键词和次数到表中
        return target;
        // return target.getAnswer();
    }

    @RequestMapping("/querytop3")
    public String querytop3(@RequestParam(value = "question") String query) throws Exception {
        queryFromStudent = query;
        return coreProcess.subQuestion(query);
    }

    /**
     * 问题爬虫 存在bug 百度知道网站爬不了
     * @param question
     * @return
     * @throws IOException
     */
    @RequestMapping("/questionSpider")
    public String questionSpider(@RequestParam(value = "question") String question) throws IOException {
        QuestionSpider questionSpider = htmlParseUtil.paraseQuetion(question);
        spiderAnswer = questionSpider.getAnswer();
        return spiderAnswer;
    }

    @RequestMapping("/subQuery")
    public String subQuery(@RequestParam(value = "question") String question) throws Exception {
        String questions = coreProcess.subQuery(question);
        if (questions.equals("")) {return "";}
        return questions;
    }

    @RequestMapping("/getAnswerByOrder")
    public String getAnswerByOrder(@RequestParam(value = "order") String order, @RequestParam(value = "questions") String questions ) throws Exception {
        circuitQa target =  coreProcess.getAnswerByOrder(order, questions);
        recordService.wordsSave(queryFromStudent, target.getQuestion(), target.getAnswer());   // 保存query和question、answer对
        keywordtimesallService.keywordInsertOrUpdate(keywordSave);                              // 保存关键词和次数到表中 有bug在选择子问题时候
        return target.getAnswer();
    }

    /**
     * bug 点完按钮 满意度反馈
     */
    @RequestMapping("/feedback")
    public void feedback(@RequestParam(value = "question") String question){
        QuestionSpider questionspider = new QuestionSpider();
        questionspider.setAnswer(spiderAnswer);
        questionspider.setQuestion(question);
        questionspider.setSatisfaction("不满意");
        questionSpiderMapper.insert(questionspider);
    }

    @RequestMapping("/feedback2")
    public String feedback2(@RequestBody QuestionSpider questionspider){
        questionspider.setQuestion(queryFromStudent);
        questionspider.setAnswer("无");
        questionSpiderMapper.insert(questionspider);
        return "提交成功，谢谢您的意见";
    }

    @RequestMapping("/loadQuery")
    public String loadQuery(){
        System.out.println(queryFromStudent);
        return queryFromStudent;
    }

    @GetMapping("/loadAllQuestions")
    public List<String> loadAllQuestions(){
        return circuitQAService.findAllQuestions();
    }

    // @RequestMapping("/questionList")
    // public void questionList(@RequestParam(value = "query") String query){
    //
    // }

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