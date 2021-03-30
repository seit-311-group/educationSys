package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.record;
import cn.sysu.circuitQA.pojo.recordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface recordMapper {
    int countByExample(recordExample example);

    int deleteByExample(recordExample example);

    int insert(record record);

    int insertSelective(record record);

    List<record> selectByExample(recordExample example);

    int updateByExampleSelective(@Param("record") record record, @Param("example") recordExample example);

    int updateByExample(@Param("record") record record, @Param("example") recordExample example);
}