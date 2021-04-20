package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.mapper.StudentMapperCustom;
import cn.sysu.circuitQA.pojo.Student;
import cn.sysu.circuitQA.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentMapperCustom studentMapperCustom;

    @Override
    public Student login(Student student) {
        Student studentExist = studentMapperCustom.findById(student.getId().longValue());
        if (studentExist != null) {
            String studentPassword = studentMapperCustom.findPswById(student.getId().longValue());
            if (student.getPassword().equals(studentPassword)){
                return studentExist;
            }
        }
        return null;
    }

    @Override
    public Student regist(Student student) {
        if(studentMapperCustom.findById(student.getId().longValue()) == null){
            return null;
        }
        Student studentExist = studentMapperCustom.findById(student.getId().longValue());
        if (student.getId() == null){
            return null;
        }else if (student.getStudentname() == null){
            return null;
        }else if (student.getPassword() == null){
            return null;
        }else if (studentExist != null){
            return null;
        } else {
            studentMapperCustom.insert(student);
        }
        return  student;
    }
}
