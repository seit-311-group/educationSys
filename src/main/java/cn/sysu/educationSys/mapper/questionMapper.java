package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.question;
import cn.sysu.educationSys.pojo.questionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface questionMapper {
    int countByExample(questionExample example);

    int deleteByExample(questionExample example);

    int insert(question record);

    int insertSelective(question record);

    List<question> selectByExample(questionExample example);

    int updateByExampleSelective(@Param("record") question record, @Param("example") questionExample example);

    int updateByExample(@Param("record") question record, @Param("example") questionExample example);
}