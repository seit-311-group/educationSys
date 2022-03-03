package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.qa.keyWord;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface KeyWordService {
    List<keyWord> importKeyWords();

    String getIDByKeyWord(String ID);

    void UpdateKeyword(String keyword, String questionId);

    Map<String, String> getAnByQuestion(String keyword) throws IOException;
}
