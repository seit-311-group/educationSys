package cn.sysu.educationSys.service.serviceImpl;

import cn.sysu.educationSys.mapper.AnswerFunctionRecordsMapper;
import cn.sysu.educationSys.pojo.answer.AnswerFunctionRecords;
import cn.sysu.educationSys.service.AnswerFunctionRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerFunctionRecordsServiceImpl implements AnswerFunctionRecordsService {
    @Autowired
    AnswerFunctionRecordsMapper answerFunctionRecordsMapper;

    @Override
    public void insertAnswerFunctionRecords(AnswerFunctionRecords answerFunctionRecords) {
        answerFunctionRecordsMapper.insertAnswerFunctionRecords(answerFunctionRecords);
    }
}
