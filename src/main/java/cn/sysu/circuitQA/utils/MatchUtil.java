package cn.sysu.circuitQA.utils;

import cn.sysu.circuitQA.gRPCclient.matchClient;
import cn.sysu.circuitQA.pojo.circuitQa;
import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MatchUtil {
    public static circuitQa matchByRPC(List<circuitQa> candidates, String query) throws InterruptedException {
        String[] sents = new String[candidates.size()];
        for (int i = 0; i < candidates.size(); i++) {
            sents[i] = candidates.get(i).getQuestion();
        }
        String target = "211.66.138.157:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        try {
            matchClient client = new matchClient(channel);
            int index = client.match(sents, query);
            return candidates.get(index);
        } finally {
            channel.shutdownNow().awaitTermination(10, TimeUnit.SECONDS);
        }
    }

    public static circuitQa match2(List<circuitQa> candidates, String query) throws IOException {
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

    public static circuitQa match1(List<circuitQa> candidates, String query) {
        circuitQa target = candidates.get(0);
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
    private static float levenshtein(String str1, String str2) {
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
    private static int min(int... is) {
        int min = Integer.MAX_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }
}
