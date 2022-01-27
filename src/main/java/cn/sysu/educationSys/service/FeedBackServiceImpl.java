package cn.sysu.educationSys.service;

import cn.sysu.educationSys.mapper.FeedbackMapper;
import cn.sysu.educationSys.pojo.Feedback;
import cn.sysu.educationSys.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public void insert(String feedback, long studentId) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);

        Feedback fb = new Feedback();
        fb.setFeedback(feedback);
        fb.setStudentid(studentId);
        fb.setTime(time);
        feedbackMapper.insert(fb);
    }
}
