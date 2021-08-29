package cn.sysu.educationSys.mapper;

import java.util.List;

public interface KeywordtimesallMapperCustom extends KeywordsAllMapper {
    List<String> getAllKeywords();

    int getTimesBykeyword(String keyword);
}