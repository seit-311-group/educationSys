package cn.sysu.educationSys.controller.answer;

import cn.sysu.educationSys.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
public class AnswerQuestionController {
    @Autowired
    QuestionService questionService;

    /**
     * 得到题目数量
     * @return
     */
    @GetMapping("/question")
    public int findAll(){
        return questionService.findAllNums();
    }

    /**
     * 更新题目的通过率
     * @param errorOptionsCount
     */
    @RequestMapping("/passRateUpdate")
    public void passRateUpdate(@RequestParam(value = "errorOptions")String errorOptionsCount){
        questionService.passRateUpdate(errorOptionsCount);
    }

}
