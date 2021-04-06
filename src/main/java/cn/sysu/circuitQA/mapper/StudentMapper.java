package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.Student;


public interface StudentMapper {
     Student findById(Long id);
     String findPswById(Long id);
     void save(Student student);
}
