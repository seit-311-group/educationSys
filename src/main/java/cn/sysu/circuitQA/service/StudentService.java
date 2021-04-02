package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.Student;

public interface StudentService {
    String login(Student student);

    String regist(Student student);
}
