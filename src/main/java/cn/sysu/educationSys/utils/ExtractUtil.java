package cn.sysu.educationSys.utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    /**
     * 去除停用词
     * @param oldString：原中文文本
     * @return 去除停用词之后的中文文本
     * @throws IOException
     */
    public static String removalOfStopWords(String oldString) throws IOException {
        String newString = oldString;

        // 分词
        List<Term> termList = HanLP.segment(newString);


        // 中文 停用词 .txt 文件路径
        String filePath = "src/main/resources/baidu_stopwords.txt";
        File file = new File(filePath);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> stopWords = new ArrayList<>();
        String temp = null;
        while ((temp = bufferedReader.readLine()) != null) {
            //System.out.println("*" + temp+ "*");
            stopWords.add(temp.trim());
        }

        List<String> termStringList = new ArrayList<>();
        for(Term term:termList) {
            termStringList.add(term.word.trim());
            //System.out.println("*" + term.word + "*");
        }

        termStringList.removeAll(stopWords);

        newString = "";
        for (String string:termStringList) {
            newString += string;
        }

        return newString;
    }

}


