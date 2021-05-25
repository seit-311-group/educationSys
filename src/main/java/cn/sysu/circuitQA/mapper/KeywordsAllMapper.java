package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.KeywordsAll;
import cn.sysu.circuitQA.pojo.KeywordsAllExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeywordsAllMapper {
    int countByExample(KeywordsAllExample example);

    int deleteByExample(KeywordsAllExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(KeywordsAll record);

    int insertSelective(KeywordsAll record);

    List<KeywordsAll> selectByExample(KeywordsAllExample example);

    KeywordsAll selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") KeywordsAll record, @Param("example") KeywordsAllExample example);

    int updateByExample(@Param("record") KeywordsAll record, @Param("example") KeywordsAllExample example);

    int updateByPrimaryKeySelective(KeywordsAll record);

    int updateByPrimaryKey(KeywordsAll record);
}