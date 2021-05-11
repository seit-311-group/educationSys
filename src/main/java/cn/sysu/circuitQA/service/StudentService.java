package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.Student;

public interface StudentService {
    Student login(int id, String password);

    Student regist(int id, String name, String password, String classandgrade);
}
