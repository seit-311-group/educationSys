package cn.sysu.educationSys.utils;

import cn.sysu.educationSys.config.ConfigProperties;
import cn.sysu.educationSys.pojo.qa.circuitQa;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

@Component
public class MatchUtil {
    @Autowired
    HttpUtil httpUtil;

    @Autowired
    ConfigProperties configProperties;

    public circuitQa match2(List<circuitQa> candidates, String query) throws IOException {
        DocVectorModel docVectorModel = new DocVectorModel(new WordVectorModel("C:/hanLP/data/polyglot-zh.txt"));
        float score = -2;
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


    public circuitQa match1(List<circuitQa> candidates, String query) {
        circuitQa target = candidates.get(0); //得到第一个question 计算其和query的相似度
        float similarity = levenshtein(query, target.getQuestion());
        for (circuitQa candidate : candidates) {
            float new_similarity = levenshtein(query, candidate.getQuestion());
            if (new_similarity > similarity) {
                target = candidate;
                similarity = new_similarity;
            }
        }
        return target;
    }

    /**
     * 找到前5个相似度最高的问题返回
     * @param candidates
     * @param question
     * @return list
     */
    public Map<circuitQa, Float> matchTop5(List<circuitQa> candidates, String question) throws Exception {
        Map<circuitQa, Float> res = new LinkedHashMap<>();
        Map<circuitQa, Float> map = new HashMap<>();        //TreeMap的key不能为对象
        // matchWithLevenshtein(map, candidates, question);       // 无监督算法
        matchWithDeepLearning(map, candidates, question);       // 深度学习算法 注意需要更改相似度阈值 深度学习为0.5
        // map按值排序 降序
        Map<circuitQa, Float> sortedMap = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        if(map.size() >= StaticVariables.FIND_MANY_QUESTION){
            int num = StaticVariables.FIND_MANY_QUESTION;
            for (Map.Entry<circuitQa, Float> circuitQaFloatEntry : sortedMap.entrySet()) {
                if (num-- == 0) break;
                res.put(circuitQaFloatEntry.getKey(), circuitQaFloatEntry.getValue());
            }
        }else {
            return sortedMap;
        }
        return res;
    }

    /**
     * 无监督的莱文斯特距离
     * @param str1
     * @param str2
     * @return
     */
    private float levenshtein(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dif = new int[len1 + 1][len2 + 1];
        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,
                        dif[i - 1][j] + 1);
            }
        }
        float similarity =1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
        return similarity;
    }
    private int min(int... is) {
        int min = Integer.MAX_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }


    private Map<circuitQa, Float> matchWithLevenshtein(Map<circuitQa, Float> map, List<circuitQa> candidates, String question){
        for (circuitQa candidate: candidates){
            float similarity = levenshtein(question,candidate.getQuestion());
            map.put(candidate, similarity);
        }
        return map;
    }

    public Map<circuitQa, Float> matchWithDeepLearning(Map<circuitQa, Float> map, List<circuitQa> candidates, String question) throws Exception {
        List<String> candidate = new ArrayList<>();
        for (circuitQa can: candidates){
            candidate.add(can.getQuestion());
        }
        JSONObject request = new JSONObject();
        request.put("question", question);
        request.put("candidate", candidate);

        // HTTP调用算法
        String res = httpUtil.post("http://" + configProperties.getAlgorithmSeverIpAndPort() + "/textMatch", request.toJSONString());
        JSONObject jsonObject = JSON.parseObject(res);

        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            for (circuitQa circuitQa : candidates) {
                if (circuitQa.getQuestion().equals(entry.getKey())){
                    map.put(circuitQa, Float.parseFloat(entry.getValue().toString()));
                    break;
                }
            }
        }
        return map;
    }
}
