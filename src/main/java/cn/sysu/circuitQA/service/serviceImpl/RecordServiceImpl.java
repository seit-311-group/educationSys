package cn.sysu.circuitQA.service.serviceImpl;

<<<<<<< HEAD
import cn.sysu.circuitQA.pojo.keyWord;
import cn.sysu.circuitQA.pojo.keyWordExample;
import cn.sysu.circuitQA.pojo.record;
import cn.sysu.circuitQA.pojo.recordExample;
import cn.sysu.circuitQA.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
=======
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
>>>>>>> origin/dev_reyo

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
<<<<<<< HEAD
    private cn.sysu.circuitQA.mapper.recordMapper recordMapper;

    public void addRecord(String query, String question, String answer, String success){
        record record = new record();
        record.setQuestion(question);
        record.setAnswer(answer);
        record.setSuccess(success);
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String nowDate = format.format(now);
        record.setDate(nowDate);
        record.setQuery(query);
        recordMapper.insert(record);
    };

    public String findRecord(String date){
        recordExample recordExample = new recordExample();
        recordExample.Criteria criteria = recordExample.createCriteria();
        String day = date.substring(0,8);
        criteria.andDateGreaterThanOrEqualTo(day);
        List<record> records = recordMapper.selectByExample(recordExample);

        String res = "";
        for (int i = 0; i < records.size(); i++){
            res = res + " " + records.get(i).getQuery();
        }
        return (res.length() == 0) ? null : res.substring(1);
=======
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
>>>>>>> origin/dev_reyo
    }
}
