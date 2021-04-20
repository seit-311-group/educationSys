package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.mapper.StudentMapper;
import cn.sysu.circuitQA.pojo.Student;

public interface StudentMapperCustom extends StudentMapper {
    Student findById(Long id);

    String findPswById(Long id);
}
