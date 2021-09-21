package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.option_t;
import cn.sysu.educationSys.pojo.point;
import cn.sysu.educationSys.pojo.question;
import cn.sysu.educationSys.pojo.subquestion;

import java.util.List;

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

    String findAnswerByQuestion(String question);
}
