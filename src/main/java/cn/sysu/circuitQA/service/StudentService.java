package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.Student;

import java.util.List;

public interface StudentService {
    Student login(Long id, String password);

    Student regist(Long id, String name, String password, String classandgrade);

    void updateQueryKeywords(Long studentId, String queryKeywords);


}
