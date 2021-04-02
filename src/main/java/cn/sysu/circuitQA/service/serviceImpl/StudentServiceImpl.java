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
    public String login(Student student) {
        try {
            Student studentExistN = studentMapper.findById(student.getId());
            if (studentExistN != null) {
                // 得到id对应学生的密码
                String studentExistPassword = studentMapper.findPswById(student.getId());
                if (studentExistPassword.equals(student.getPassword())) {
                    flag = studentExistN.getUsername() + "同学登录成功，欢迎您";
                } else {
                    flag = "登陆失败，密码错误";
                }
            }else {
                flag = "登陆失败，账户不存在";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public String regist(Student student) {
        try {
            // if (student.getId().equals())
            Student studentExist = studentMapper.findById(student.getId());
            if (student.getId() == null) {
                flag = "学号不能为空";
            }else if (student.getUsername() == null){
                flag = "用户名不能为空";
            }else if (student.getPassword() == null){
                flag = "密码不能为空";
            }else if (studentExist != null){
                flag = "账户已经存在";
            } else {
                studentMapper.save(student);
                flag = "注册成功";
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
