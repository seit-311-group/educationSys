package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.Questionspider;
import cn.sysu.circuitQA.pojo.QuestionspiderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionspiderMapper {
    int countByExample(QuestionspiderExample example);

    int deleteByExample(QuestionspiderExample example);

    int insert(Questionspider record);

    int insertSelective(Questionspider record);

    List<Questionspider> selectByExample(QuestionspiderExample example);

    int updateByExampleSelective(@Param("record") Questionspider record, @Param("example") QuestionspiderExample example);

    int updateByExample(@Param("record") Questionspider record, @Param("example") QuestionspiderExample example);
}