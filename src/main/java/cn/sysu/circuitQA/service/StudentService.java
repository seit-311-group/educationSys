package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.Student;

public interface StudentService {
    Student login(Student student);

    Student regist(Student student);
}
