package cn.sysu.educationSys.service.serviceImpl;

import cn.sysu.educationSys.pojo.*;
import cn.sysu.educationSys.service.AnswerRecordsService;
import cn.sysu.educationSys.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private cn.sysu.educationSys.mapper.questionMapper questionMapper;
    @Autowired
    private cn.sysu.educationSys.mapper.pointMapper pointMapper;
    @Autowired
    private cn.sysu.educationSys.mapper.subquestionMapper subquestionMapper;
    @Autowired
    private cn.sysu.educationSys.mapper.option_tMapper option_tMapper;
    @Autowired
    AnswerRecordsService answerRecordsService;

    @Override
    public List<question> getQuestionsByID(String ID) {
        questionExample questionExample = new questionExample();
        questionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIdEqualTo(Integer.valueOf(ID));
        return questionMapper.selectByExample(questionExample);
    }

    @Override
    public List<subquestion> getSubquestionsByID(String ID) {
        subquestionExample subquestionExample = new subquestionExample();
        subquestionExample.Criteria criteria = subquestionExample.createCriteria();
        criteria.andIdEqualTo(Integer.valueOf(ID));
        return subquestionMapper.selectByExample(subquestionExample);
    }

    @Override
    public List<point> getPointsByID(String ID) {
        pointExample pointExample = new pointExample();
        pointExample.Criteria criteria = pointExample.createCriteria();
        criteria.andIdEqualTo(Integer.valueOf(ID));
        return pointMapper.selectByExample(pointExample);
    }

    @Override
    public List<option_t> getOptionsByID(String ID) {
        option_tExample option_tExample = new option_tExample();
        option_tExample.Criteria criteria = option_tExample.createCriteria();
        criteria.andIdEqualTo(Integer.valueOf(ID));
        return option_tMapper.selectByExample(option_tExample);
    }

    /**
     * 找到所有的问题对象
     * @return 问题对象
     */
    @Override
    public String findAllQuestion() {
        List<question> questions = findAll();
        String res = "";
        for (question question : questions) {
            res += question.getDescription() + "@" + question.getKeyword() + "@" + question.getPassrate() + "@";
        }
        return res;
    }

    @Override
    public List<question> findAll() {
        questionExample questionExample = new questionExample();
        List<question> questions = questionMapper.selectByExample(questionExample);
        return questions;
    }

    @Override
    public int findAllNums() {
        List<question> all = findAll();
        return all.size();
    }

    /**
     * 根据知识点找到知识点id
     * @param content
     * @return
     */
    @Override
    public String findPointByContent(String content) {
        pointExample pointExample = new pointExample();
        cn.sysu.educationSys.pojo.pointExample.Criteria criteria = pointExample.createCriteria();
        criteria.andContentEqualTo(content);
        point point = new point();
        List<cn.sysu.educationSys.pojo.point> points = pointMapper.selectByExample(pointExample);
        return points.get(0).getId().toString();
    }

    @Override
    public void passRateUpdate(String errorOptionsCount) {
        String[] split = errorOptionsCount.split("@");
        List<question> questionsByID = getQuestionsByID(split[0]);
        question question = questionsByID.get(0);
        int sumOptions = countAllOption(split[0],question);
        int errorOptions = Integer.parseInt(split[1]);
        int correctOptions = sumOptions - errorOptions;
        DecimalFormat df = new DecimalFormat("0.00");
        double oneRate = Double.parseDouble(df.format((double) correctOptions / sumOptions));
        int n = answerRecordsService.countRecordsByQuestionId(split[0]);

        questionExample questionExample = new questionExample();
        cn.sysu.educationSys.pojo.questionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIdEqualTo(question.getId());
        question question1 = new question();
        if(null == question.getPassrate()|| question.getPassrate().equals(0)){
            question1.setPassrate(oneRate);
        }else{
            double newPassRate = Double.parseDouble(df.format((double)(((n - 1) * question.getPassrate() + oneRate)/n)));
            question1.setPassrate(newPassRate);
        }
        questionMapper.updateByExampleSelective(question1,questionExample);
    }

    @Override
    public int countAllOption(String questionId, question question) {
        String subQuestionId = question.getSubquesid();
        String[] split = subQuestionId.split(",");
        int countSubquesitons = split.length;
        int count = 0;
        for (String s : split) {
            List<subquestion> subquestionsByID = getSubquestionsByID(s);
            count += subquestionsByID.get(0).getOptionid().split(",").length;
        }

        return count-countSubquesitons;
    }
}
