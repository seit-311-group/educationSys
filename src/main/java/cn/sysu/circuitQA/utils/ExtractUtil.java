package cn.sysu.circuitQA.utils;

import com.hankcs.hanlp.HanLP;

import java.util.List;

public class ExtractUtil {
    public static String extract (String question) {
        List<String> keywordList = HanLP.extractKeyword(question, 1);
        String keyword = keywordList.size() > 0 ? keywordList.get(0) : "";
        return keyword;
    }
}


