package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.Keywordtimesall;
import cn.sysu.circuitQA.pojo.KeywordtimesallExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeywordtimesallMapperCustom extends  KeywordtimesallMapper{
    List<String> getAllKeywords();

    int getTimesBykeyword(String keyword);
}