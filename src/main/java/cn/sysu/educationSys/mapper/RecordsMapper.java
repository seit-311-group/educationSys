package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.answer.Records;
import cn.sysu.educationSys.pojo.answer.RecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordsMapper {
    int countByExample(RecordsExample example);

    int deleteByExample(RecordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Records record);

    int insertSelective(Records record);

    List<Records> selectByExample(RecordsExample example);

    Records selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Records record, @Param("example") RecordsExample example);

    int updateByExample(@Param("record") Records record, @Param("example") RecordsExample example);

    int updateByPrimaryKeySelective(Records record);

    int updateByPrimaryKey(Records record);
}