package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.mapper.RecordMapper;
import cn.sysu.circuitQA.mapper.StudentMapper;
import cn.sysu.circuitQA.pojo.Record;
import cn.sysu.circuitQA.pojo.Student;
import cn.sysu.circuitQA.service.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    HttpServletRequest request;

    @Override
    public String wordsSave(String question) {
        Date date = new Date();//获得系统当前时间.
        SimpleDateFormat sdf = new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);

        // 获取cookie 得到学生登录状态
        Student student = new Student();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("studentId")) {
                long studentId = Integer.parseInt(cookie.getValue());
                student = studentMapper.findById(studentId);
            }
        }

        Record record = new Record();
        record.setQuestion(question);
        record.setTime(nowTime);
        record.setStudentName(student.getStudentName());
        record.setStudentid(student.getId());

        recordMapper.save(record);
        return "问题保存成功";
    }
}
