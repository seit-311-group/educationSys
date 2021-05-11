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
    public Student login(int id, String password) {
        Student studentExist = studentMapperCustom.findById((long)id);
        if (studentExist != null) { //用户存在
            String studentPassword = studentMapperCustom.findPswById((long)id);
            if (password.equals(studentPassword)){
                return studentExist;
            }
        }
        return null;
    }

    @Override
    public Student regist(int id, String name, String password, String classandgrade) {
        Student student = new Student();
        student.setId(id);
        student.setStudentname(name);
        student.setPassword(password);
        student.setClassandgrade(classandgrade);
        if(studentMapperCustom.findById((long)id) != null){  //用户存在
            return null;
        }
        studentMapperCustom.insert(student);
        return student;
    }
}
