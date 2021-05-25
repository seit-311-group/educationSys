package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.service.KeywordtimesallService;

import java.util.List;

public interface KeywordtimesallMapperCustom extends KeywordsAllMapper {
    List<String> getAllKeywords();

    int getTimesBykeyword(String keyword);
}