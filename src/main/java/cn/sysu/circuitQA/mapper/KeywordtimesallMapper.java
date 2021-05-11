package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.Keywordtimesall;
import cn.sysu.circuitQA.pojo.KeywordtimesallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeywordtimesallMapper {
    int countByExample(KeywordtimesallExample example);

    int deleteByExample(KeywordtimesallExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Keywordtimesall record);

    int insertSelective(Keywordtimesall record);

    List<Keywordtimesall> selectByExample(KeywordtimesallExample example);

    Keywordtimesall selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Keywordtimesall record, @Param("example") KeywordtimesallExample example);

    int updateByExample(@Param("record") Keywordtimesall record, @Param("example") KeywordtimesallExample example);

    int updateByPrimaryKeySelective(Keywordtimesall record);

    int updateByPrimaryKey(Keywordtimesall record);
}