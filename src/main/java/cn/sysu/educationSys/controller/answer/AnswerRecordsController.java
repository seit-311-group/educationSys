package cn.sysu.educationSys.controller.answer;

import cn.sysu.educationSys.pojo.answer.AnswerRecords;
import cn.sysu.educationSys.service.AnswerRecordsService;
import cn.sysu.educationSys.service.CookieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/answerRecords")
public class AnswerRecordsController {

    @Autowired
    AnswerRecordsService answerRecordsService;

    @Autowired
    CookieSessionService cookieSessionService;

    /**
     * 得到所有答题记录
     * @param map
     * @return
     */
    @PostMapping("/showAllRecords")
    public List<AnswerRecords> showAllRecords(@RequestBody Map map){
        List<AnswerRecords> recordsByStudentId = answerRecordsService.findRecordsByStudentId(cookieSessionService.findStudentByCookie().getId(),map.get("questionid").toString());
        return recordsByStudentId;
    }

    /**
     * 通过做题结果找到所有知识点
     * @param map
     * @return
     */
    @PostMapping("/getAllPoints")
    public String getAllPoints(@RequestBody Map map){
        return answerRecordsService.getAllPoints(map.get("pointId").toString());
    }
}
