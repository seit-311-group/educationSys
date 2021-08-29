package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.keyWord;
import cn.sysu.educationSys.pojo.keyWordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface keyWordMapper {
    int countByExample(keyWordExample example);

    int deleteByExample(keyWordExample example);

    int insert(keyWord record);

    int insertSelective(keyWord record);

    List<keyWord> selectByExample(keyWordExample example);

    int updateByExampleSelective(@Param("record") keyWord record, @Param("example") keyWordExample example);

    int updateByExample(@Param("record") keyWord record, @Param("example") keyWordExample example);
}