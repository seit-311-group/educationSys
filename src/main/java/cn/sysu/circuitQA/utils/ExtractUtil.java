package cn.sysu.circuitQA.utils;

import com.hankcs.hanlp.HanLP;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExtractUtil {
    public static String extract (String question) {
        List<String> keywordList = HanLP.extractKeyword(question, 1);
        String keyword = keywordList.size() > 0 ? keywordList.get(0) : "";
        return keyword;
    }

    public static List<String> extractAll (String question) {
        List<String> keywordList = HanLP.extractKeyword(question,3);    // size为提取词的个数
        return keywordList;
    }
}


