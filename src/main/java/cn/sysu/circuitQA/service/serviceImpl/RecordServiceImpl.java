package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.mapper.RecordMapperCustom;
import cn.sysu.circuitQA.mapper.StudentMapperCustom;
import cn.sysu.circuitQA.pojo.Record;
import cn.sysu.circuitQA.pojo.Student;
import cn.sysu.circuitQA.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


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
    RecordMapperCustom recordMapperCustom;

    @Autowired
    StudentMapperCustom studentMapperCustom;

    @Autowired
    HttpServletRequest request;

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
                long studentId = Integer.parseInt(cookie.getValue());
                student = studentMapperCustom.findById(studentId);
            }
        }

        // 如果相同的用户问了相同的问题不计入
        List<String> allQuery = recordMapperCustom.getAllQuery();
        if(!allQuery.contains(query)){
            Record record = new Record();
            record.setQuery(query);
            record.setAnswer(answer);
            record.setQuestion(question);
            record.setTime(nowTime);
            record.setStudentname(student.getStudentname());
            record.setStudentid(student.getId());

            recordMapperCustom.insert(record);
            System.out.println("问题保存成功");

        }

        System.out.println("问题保存失败，是相同问题");
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
        String spPage= pageNumber;
        //设置每页条数
        int pageSize=15;
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
        int count=recordMapperCustom.getCount(search);
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
        List<Record> records = recordMapperCustom.pageList(map);
        //最后把信息放入model转发到页面把信息带过去
        model.addAttribute("records",records);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("maxPage",maxPage);
        model.addAttribute("search", search);
    }

}
