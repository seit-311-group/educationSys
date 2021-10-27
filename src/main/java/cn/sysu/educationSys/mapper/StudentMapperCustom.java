package cn.sysu.educationSys.mapper.student;

import cn.sysu.educationSys.pojo.student.Student;

public interface StudentMapperCustom extends StudentMapper {
    Student findById(Long id);

    String findPswById(Long id);

    void insertLoginRecord(Long id);

    void insertRegisterRecord(Long id);
}
