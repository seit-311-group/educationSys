package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.mapper.StudentMapper;
import cn.sysu.circuitQA.pojo.Student;
import cn.sysu.circuitQA.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    String flag = null;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student login(Student student) {
        Student studentExist = studentMapper.findById(student.getId());
        if (studentExist != null) {
            String studentPassword = studentMapper.findPswById(student.getId());
            if (student.getPassword().equals(studentPassword)){
                return studentExist;
            }
        }
        return null;
    }

    @Override
    public Student regist(Student student) {
        Student studentExist = studentMapper.findById(student.getId());
        if (student.getId() == null){
            return null;
        }else if (student.getStudentName() == null){
            return null;
        }else if (student.getPassword() == null){
            return null;
        }else if (studentExist != null){
            return null;
        } else {
            studentMapper.save(student);
        }
        return  student;
    }
}
