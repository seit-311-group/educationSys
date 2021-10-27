package cn.sysu.educationSys.mapper;

import org.apache.ibatis.annotations.Param;

public interface QuestionRecordMapper {
    void insertRecord(@Param("question") String question, @Param("id") Long id);
}
