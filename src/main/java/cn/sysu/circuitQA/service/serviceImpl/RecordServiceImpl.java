package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.mapper.RecordMapper;
import cn.sysu.circuitQA.pojo.Record;
import cn.sysu.circuitQA.service.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public String wordsSave(String question) {
        Date date = new Date();//获得系统当前时间.
        SimpleDateFormat sdf = new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);

        Record record = new Record();
        record.setQuestion(question);
        record.setTime(nowTime);
        // 写入学生的学号
        // record.setStudentid(123123);

        recordMapper.save(record);
        return "问题保存成功";
    }
}
