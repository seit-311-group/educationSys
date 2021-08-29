package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.AnswerRecords;
import cn.sysu.educationSys.pojo.AnswerRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswerRecordsMapper {
    int countByExample(AnswerRecordsExample example);

    int deleteByExample(AnswerRecordsExample example);

    int insert(AnswerRecords record);

    int insertSelective(AnswerRecords record);

    List<AnswerRecords> selectByExample(AnswerRecordsExample example);

    int updateByExampleSelective(@Param("record") AnswerRecords record, @Param("example") AnswerRecordsExample example);

    int updateByExample(@Param("record") AnswerRecords record, @Param("example") AnswerRecordsExample example);
}