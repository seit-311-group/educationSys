package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.mapper.RecordMapper;
import cn.sysu.circuitQA.mapper.StudentMapper;
import cn.sysu.circuitQA.pojo.Record;
import cn.sysu.circuitQA.pojo.Student;
import cn.sysu.circuitQA.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.util.StringUtils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        record.setStudentname(student.getStudentname());
        record.setStudentid(student.getId());

        recordMapper.save(record);
        return "问题保存成功";
    }

    // 分页和显示

    /**
     * 有bug
     * @param search
     * @param pageNumber
     * @param model
     */
    @Override
    public void pagingAndShow(String search,String pageNumber, Model model) {
        String spPage= pageNumber;
        //设置每页条数
        int pageSize=13;
        //页数
        int pageNo=0;
        if (search == null) search = "";
        if(spPage==null){
            pageNo=1;
        }else {
            pageNo = Integer.valueOf(spPage);
            if (pageNo < 1) {
                pageNo = 1;
            }
        }
        //设置最大页数
        int totalCount=0;
        int count=recordMapper.getCount(search);
        if(count>0){
            totalCount=count;
        }
        int maxPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        if(pageNo>maxPage){
            pageNo=maxPage;
        }
        int tempPageNo=(pageNo-1)*pageSize;
        //计算总数量
        //分页查询
        Map map=new HashMap();
        map.put("pageNo",tempPageNo);
        map.put("pageSize",pageSize);
        map.put("search", search);
        List<Record> records = recordMapper.pageList(map);
        //最后把信息放入model转发到页面把信息带过去
        model.addAttribute("records",records);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("maxPage",maxPage);
        model.addAttribute("search", search);
    }

}
