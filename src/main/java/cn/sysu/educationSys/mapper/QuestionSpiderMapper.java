package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.QuestionSpider;
import cn.sysu.educationSys.pojo.QuestionSpiderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionSpiderMapper {
    int countByExample(QuestionSpiderExample example);

    int deleteByExample(QuestionSpiderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionSpider record);

    int insertSelective(QuestionSpider record);

    List<QuestionSpider> selectByExample(QuestionSpiderExample example);

    QuestionSpider selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionSpider record, @Param("example") QuestionSpiderExample example);

    int updateByExample(@Param("record") QuestionSpider record, @Param("example") QuestionSpiderExample example);

    int updateByPrimaryKeySelective(QuestionSpider record);

    int updateByPrimaryKey(QuestionSpider record);
}