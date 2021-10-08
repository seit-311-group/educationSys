package cn.sysu.educationSys.service.serviceImpl;

import cn.sysu.educationSys.mapper.AnswerRecordsMapper;
import cn.sysu.educationSys.pojo.answer.AnswerRecords;
import cn.sysu.educationSys.pojo.answer.AnswerRecordsExample;
import cn.sysu.educationSys.service.AnswerRecordsService;
import cn.sysu.educationSys.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerRecordsServiceImpl implements AnswerRecordsService {

    @Autowired
    AnswerRecordsMapper answerRecordsMapper;

    @Autowired
    QuestionService questionService;

    @Override
    public void insertRecord(AnswerRecords answerRecords) {
        answerRecordsMapper.insert(answerRecords);
    }

    @Override
    public List<AnswerRecords> findRecordsByStudentId(Long studentId, String questionId) {
        AnswerRecordsExample answerRecordsExample = new AnswerRecordsExample();
        AnswerRecordsExample.Criteria criteria = answerRecordsExample.createCriteria();
        criteria.andStudentidEqualTo(studentId);
        criteria.andQuestionidEqualTo(Integer.parseInt(questionId));
        List<AnswerRecords> answerRecordsById = answerRecordsMapper.selectByExample(answerRecordsExample);
        return answerRecordsById;
    }

    @Override
    public String getAllPoints(String result) {
        String[] points = result.split("/");
        StringBuffer res = new StringBuffer();
        int index = 1;
        for (String point : points) {
            res.append(index + "." + questionService.getPointsByID(point).get(0).getContent() + "\n");
            index++;
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    @Override
    public int countRecordsByQuestionId(String questionId) {
        AnswerRecordsExample answerRecordsExample = new AnswerRecordsExample();
        AnswerRecordsExample.Criteria criteria = answerRecordsExample.createCriteria();
        criteria.andQuestionidEqualTo(Integer.parseInt(questionId));
        int count = answerRecordsMapper.selectByExample(answerRecordsExample).size();
        return count;
    }
}
