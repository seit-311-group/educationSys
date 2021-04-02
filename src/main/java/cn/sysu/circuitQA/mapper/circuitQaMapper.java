package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.circuitQa;
import cn.sysu.circuitQA.pojo.circuitQaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface circuitQaMapper {
    int countByExample(circuitQaExample example);

    int deleteByExample(circuitQaExample example);

    int insert(circuitQa record);

    int insertSelective(circuitQa record);

    List<circuitQa> selectByExample(circuitQaExample example);

    int updateByExampleSelective(@Param("record") circuitQa record, @Param("example") circuitQaExample example);

    int updateByExample(@Param("record") circuitQa record, @Param("example") circuitQaExample example);

}