package cn.sysu.circuitQA.service;

import cn.sysu.circuitQA.pojo.keyWord;

import java.util.List;

public interface KeyWordService {
    List<keyWord> importKeyWords();

    String getIDByKeyWord(String ID);

    void UpdateKeyword(String keyword, String questionId);
}
