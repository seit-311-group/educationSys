package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.mapper.StudentMapper;
import cn.sysu.circuitQA.mapper.StudentMapperCustom;
import cn.sysu.circuitQA.pojo.Student;
import cn.sysu.circuitQA.pojo.StudentExample;
import cn.sysu.circuitQA.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapperCustom studentMapperCustom;

    @Override
    public Student login(Long id, String password) {
        Student studentExist = studentMapperCustom.findById(id);
        if (studentExist != null) { //用户存在
            String studentPassword = studentMapperCustom.findPswById((long)id);
            if (password.equals(studentPassword)){
                return studentExist;
            }
        }
        return null;
    }

    @Override
    public Student regist(Long id, String name, String password, String classandgrade) {
        Student student = new Student();
        student.setId(id);
        student.setStudentname(name);
        student.setPassword(password);
        student.setClassandgrade(classandgrade);
        if(studentMapperCustom.findById(id) != null){  //用户存在
            return null;
        }
        studentMapperCustom.insert(student);
        return student;
    }



    @Override
    public void updateQueryKeywords(Long studentId, String queryKeywords) {
        Student studentExist = studentMapperCustom.findById((long) studentId);
        String allKeywords = studentExist.getQuerykeywords();
        String res = "";


        // 例：电路,2@戴维南,1@
        if(allKeywords != null){
            if(!allKeywords.contains(queryKeywords)){
                res = allKeywords + queryKeywords + ",1@";
            }else{
                String[] splits = allKeywords.split("@");
                for (String split : splits) {
                    String[] s = split.split(",");
                    if(s[0].equals(queryKeywords)){
                        s[1] = String.valueOf(Integer.parseInt(s[1]) + 1);
                    }
                    res += s[0] + "," + s[1] + "@";
                }
            }
        }else{
            res += queryKeywords + ",1@";
        }

        Student student = new Student();
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdEqualTo(studentId);
        student.setQuerykeywords(res);
        studentMapperCustom.updateByExampleSelective(student, studentExample);
    }


}
