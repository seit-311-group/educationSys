package cn.sysu.educationSys.service;

import cn.sysu.educationSys.mapper.QuestionRecordMapper;
import cn.sysu.educationSys.mapper.RecordMapperCustom;
import cn.sysu.educationSys.mapper.StudentMapperCustom;
import cn.sysu.educationSys.pojo.answer.Records;
import cn.sysu.educationSys.pojo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;


@Service
public class RecordServiceImpl implements RecordService {

    private static Logger logger = Logger.getLogger(String.valueOf(RecordServiceImpl.class));

    @Autowired
    RecordMapperCustom recordMapperCustom;

    @Autowired
    StudentMapperCustom studentMapperCustom;

    @Autowired
    CookieSessionService cookieSessionService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    QuestionRecordMapper questionRecordMapper;

    @Override
    public void wordsSave(String query,String question, String answer) {
        Date date = new Date();//获得系统当前时间.
        SimpleDateFormat sdf = new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);

        // 获取cookie 得到学生登录状态
        Student student = new Student();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("studentId")) {
                long studentId = Long.parseLong(cookie.getValue());
                student = studentMapperCustom.findById(studentId);
            }
        }

        Records record = new Records();
        record.setQuery(query);
        record.setAnswer(answer);
        record.setQuestion(question);
        record.setTime(nowTime);
        record.setStudentname(student.getStudentname());
        record.setStudentid(student.getId());

        recordMapperCustom.insert(record);
        logger.info("问题问答记录成功");
    }

    // 分页和显示

    /**
     * 问答历史页面
     * @param search 目前搜索使用的是like匹配 没有用正则
     * @param pageNumber
     * @param model
     */
    @Override
    public void pagingAndShow(String search,String pageNumber, Model model) {
        Long studentIdSave = cookieSessionService.findStudentByCookie().getId();
        String spPage= pageNumber;
        //设置每页条数
        int pageSize=8;
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
        int count  = 0;
        if (!studentIdSave.equals((long)1)){
            Map map1=new HashMap();
            map1.put("search", search);
            map1.put("studentId", studentIdSave);
            count=recordMapperCustom.getCount(map1);
        }else{
            count=recordMapperCustom.getCountAll(search);
        }

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
        List<Records> records = new ArrayList<>();
        if (!studentIdSave.equals((long)1)){
            map.put("studentId", studentIdSave);
            if (count != 0){
                records = recordMapperCustom.pageList(map);
            }
        }else{
            records = recordMapperCustom.pageListAll(map);
        }

        model.addAttribute("records",records);
        //最后把信息放入model转发到页面把信息带过去
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("maxPage",maxPage);
        model.addAttribute("search", search);
    }

    @Override
    public void questionSave(String question) {
        // 获取cookie 得到学生登录状态
        Student student = new Student();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("studentId")) {
                long studentId = Long.parseLong(cookie.getValue());
                student = studentMapperCustom.findById(studentId);
            }
        }
        questionRecordMapper.insertRecord(question, student.getId());
    }

}
