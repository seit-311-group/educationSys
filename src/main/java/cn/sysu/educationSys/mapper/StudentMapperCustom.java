package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.Student;

public interface StudentMapperCustom extends StudentMapper {
    Student findById(Long id);

    String findPswById(Long id);
}
