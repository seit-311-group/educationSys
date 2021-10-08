package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.qa.keyWord;

import java.util.List;

public interface KeyWordService {
    List<keyWord> importKeyWords();

    String getIDByKeyWord(String ID);

    void UpdateKeyword(String keyword, String questionId);
}
