package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.answer.FunctionMatch;
import cn.sysu.educationSys.pojo.answer.option_t;
import cn.sysu.educationSys.pojo.answer.point;
import cn.sysu.educationSys.pojo.qa.question;
import cn.sysu.educationSys.pojo.answer.subquestion;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 这个service是答题系统不是问答系统的
 */
public interface QuestionService {
    List<question> getQuestionsByID(String ID);

    List<subquestion> getSubquestionsByID(String ID);

    List<point> getPointsByID(String ID);

    List<option_t> getOptionsByID(String ID);

    String findAllQuestion();

    List<question> findAll();

    int findAllNums();

    String findPointByContent(String content);

    void passRateUpdate(String errorOptionsCount);

    int countAllOption(String questionId, question question);

    String upLoadPic(MultipartFile[] picture, Long studentId, String description);

    boolean isListEquation(String subQuestionId);

    String findRightFunction(String subQuestionId);

    String matchFunction(FunctionMatch functionMatch) throws JsonProcessingException;
}
