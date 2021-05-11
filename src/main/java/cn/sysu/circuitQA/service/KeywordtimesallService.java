package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.Keywordtimesall;

import java.util.List;

public interface KeywordtimesallService {
    void keywordUpdate(String keyword, int num);

    void keywordInsertOrUpdate(String keyword);
}
