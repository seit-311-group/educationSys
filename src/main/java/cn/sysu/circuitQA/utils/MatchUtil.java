package cn.sysu.circuitQA.utils;

import cn.sysu.circuitQA.pojo.circuitQa;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchUtil {
    public static circuitQa match (List<circuitQa> candidates, String query) throws IOException {
        DocVectorModel docVectorModel = new DocVectorModel(new WordVectorModel("C:/hanLP/data/polyglot-zh.txt"));
        Map<circuitQa, Integer> map = new HashMap<circuitQa, Integer>();
        float score = -1;
        circuitQa target = null;
        for (circuitQa candidate : candidates){
            float cur = docVectorModel.similarity(candidate.getQuestion(), query);
            if (cur > score) {
                score = cur;
                target = candidate;
            }
        }
        return target;
    }
}
