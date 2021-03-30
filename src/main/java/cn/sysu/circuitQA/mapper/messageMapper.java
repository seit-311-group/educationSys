package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.message;
import cn.sysu.circuitQA.pojo.messageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface messageMapper {
    int countByExample(messageExample example);

    int deleteByExample(messageExample example);

    int insert(message record);

    int insertSelective(message record);

    List<message> selectByExample(messageExample example);

    int updateByExampleSelective(@Param("record") message record, @Param("example") messageExample example);

    int updateByExample(@Param("record") message record, @Param("example") messageExample example);
}