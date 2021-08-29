package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.option_t;
import cn.sysu.educationSys.pojo.option_tExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface option_tMapper {
    int countByExample(option_tExample example);

    int deleteByExample(option_tExample example);

    int insert(option_t record);

    int insertSelective(option_t record);

    List<option_t> selectByExample(option_tExample example);

    int updateByExampleSelective(@Param("record") option_t record, @Param("example") option_tExample example);

    int updateByExample(@Param("record") option_t record, @Param("example") option_tExample example);
}