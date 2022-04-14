package cn.sysu.educationSys.controller.answer;

import cn.sysu.educationSys.pojo.answer.*;
import cn.sysu.educationSys.pojo.qa.question;
import cn.sysu.educationSys.service.AnswerFunctionRecordsService;
import cn.sysu.educationSys.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solution")
public class QueryController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerFunctionRecordsService answerFunctionRecordsService;

    /**
     * 得到题目描述
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getDescriptionBYId")
    public String getDescriptionBYId(@RequestParam(value = "id") String id) throws Exception {
        List<question> questions = questionService.getQuestionsByID(id);
        question question = null;
        if (questions.size() == 1) {
            question = questions.get(0);
        }
        return question.getDescription();
    }

    /**
     * 得到题目分析
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getAnalysisBYId")
    public String getAnalysisBYId(@RequestParam(value = "id") String id) throws Exception {
        List<question> questions = questionService.getQuestionsByID(id);
        question question = null;
        if (questions.size() == 1) {
            question = questions.get(0);
        }
        return question.getAnalysis();
    }

    /**
     * 通过问题ID找到子问题ID
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getSubquesIDsBYId")
    public String getSubquesIDsBYId(@RequestParam(value = "id") String id) throws Exception {
        List<question> questions = questionService.getQuestionsByID(id);
        question question = null;
        if (questions.size() == 1) {
            question = questions.get(0);
        }
        return question.getSubquesid();
    }

    /**
     * 通过问题ID找到知识点ID
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getPointIDsBYId")
    public String getPointIDsBYId(@RequestParam(value = "id") String id) throws Exception {
        List<question> questions = questionService.getQuestionsByID(id);
        question question = null;
        if (questions.size() == 1) {
            question = questions.get(0);
        }
        return question.getPointid();
    }

    /**
     * 通过问题ID找到答案
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getAnswerByID")
    public String getAnswerByID(@RequestParam(value = "id") String id) throws Exception {
        List<question> questions = questionService.getQuestionsByID(id);
        question question = null;
        if (questions.size() == 1) {
            question = questions.get(0);
        }
        return question.getAnswer();
    }

    /**
     * 通过问题ID找到要添加的图片
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getAddPictureByID")
    public String getAddPictureByID(@RequestParam(value = "id") String id) throws Exception {
        List<question> questions = questionService.getQuestionsByID(id);
        question question = null;
        if (questions.size() == 1) {
            question = questions.get(0);
        }
        return question.getAddpicture();
    }

    /**
     * 通过问题ID找到要替换的图片
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getChangePictureByID")
    public String getChangePictureByID(@RequestParam(value = "id") String id) throws Exception {
        List<question> questions = questionService.getQuestionsByID(id);
        question question = null;
        if (questions.size() == 1) {
            question = questions.get(0);
        }
        return question.getChangepicture();
    }

    /**
     * 通过子问题ID找到子问题的内容
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getContentBYSubquesId")
    public String getContentBYSubquesId(@RequestParam(value = "id") String id) throws Exception {
        List<subquestion> subquestions = questionService.getSubquestionsByID(id);
        subquestion subquestion = null;
        if (subquestions.size() == 1) {
            subquestion = subquestions.get(0);
        }
        return subquestion.getContent();
    }

    /**
     * 通过子问题ID找到子问题选项的答案对应Id
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getAnswerBYSubquesId")
    public int getAnswerBYSubquesId(@RequestParam(value = "id") String id) throws Exception {
        List<subquestion> subquestions = questionService.getSubquestionsByID(id);
        subquestion subquestion = null;
        if (subquestions.size() == 1) {
            subquestion = subquestions.get(0);
        }
        return subquestion.getAnswer();
    }

    /**
     * 通过子问题ID找到选项的Id
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getOptionIDBYSubquesId")
    public String getOptionIDBYSubquesId(@RequestParam(value = "id") String id) throws Exception {
        List<subquestion> subquestions = questionService.getSubquestionsByID(id);
        subquestion subquestion = null;
        if (subquestions.size() == 1) {
            subquestion = subquestions.get(0);
        }
        return subquestion.getOptionid();
    }


    /**
     * 通过选项Id找到选项的内容
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getContentBYOptionId")
    public String getContentBYOptionId(@RequestParam(value = "id") String id) throws Exception {
        List<option_t> option_ts = questionService.getOptionsByID(id);
        option_t option_t = null;
        if (option_ts.size() == 1) {
            option_t = option_ts.get(0);
        }
        return option_t.getContent();
    }

    /**
     * 通过选项Id找到选项对应的知识点Id
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getPointIDBYOptionID")
    public String getPointIDBYOptionID(@RequestParam(value = "id") String id) throws Exception {
        List<option_t> option_ts = questionService.getOptionsByID(id);
        option_t option_t = null;
        if (option_ts.size() == 1) {
            option_t = option_ts.get(0);
        }
        return option_t.getPointid();
    }

    /**
     * 通过知识点Id找到知识点内容
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getContentBYPointId")
    public String getContentBYPointId(@RequestParam(value = "id") String id) throws Exception {
        List<point> points = questionService.getPointsByID(id);
        point point = null;
        if (points.size() == 1) {
            point = points.get(0);
        }
        return point.getContent();
    }

    /**
     * 通过子问题Id判断该子问题能否列方程
     * @param subQuestionId
     * @return
     */
    @RequestMapping("/isListEquation")
    public boolean isListEquation(@RequestParam(value = "subQuestionId") String subQuestionId){
        return questionService.isListEquation(subQuestionId);
    }

    /**
     * 通过子问题Id找到该子问题对应的正确方程
     * @param subQuestionId
     * @return
     */
    @RequestMapping("/findRightFunction")
    public String findRightFunction(@RequestParam(value = "subQuestionId") String subQuestionId){
        return questionService.findRightFunction(subQuestionId);
    }

    /**
     * 公式匹配 接收json返回一个json
     * @param answerFunctionRecords
     * @return
     */
    @RequestMapping("/matchFunction")
    public String matchFunction(@RequestBody AnswerFunctionRecords answerFunctionRecords) throws JsonProcessingException {
        return questionService.matchFunction(answerFunctionRecords);
    }

    /**
     * 公式匹配反馈
     * @param answerFunctionFeedback
     */
    @RequestMapping("/matchFunctionFeedback")
    public void matchFunctionFeedBack(@RequestBody AnswerFunctionFeedback answerFunctionFeedback){
        answerFunctionRecordsService.insertAnswerFunctionFeedback(answerFunctionFeedback);
    }


    /**
     * 通过子问题Id找到子问题对应的知识点
     * @param id
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/getSubQuestionAndPointsMap")
    public String getSubQuestionAndPointsMap(@RequestParam(value = "id") int id) throws JsonProcessingException {
        return questionService.findPointsById(id);
    }

}
