package cn.sysu.circuitQA;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.io.IOException;
import java.util.List;
//import com.hankcs.hanlp.utility.TestUtility;

public class hanlpTest
{
    public static void main(String[] args) throws IOException {
//        String query = "什么是过渡过程？";
//        DocVectorModel docVectorModel = new DocVectorModel(new WordVectorModel("C:/hanLP/data/polyglot-zh.txt"));
//        System.out.println(docVectorModel.similarity("什么是电路的过渡过程？", "什么是过渡过程？"));
//        System.out.println(docVectorModel.similarity("二阶电路中，过渡过程的性质取决于什么因素？", query));
        NLPTokenizer.ANALYZER.enableCustomDictionary(false); // 不用词典照样分词。
        System.out.println(NLPTokenizer.segment("如何理解电流、电压、功率的正负？"));
        NLPTokenizer.ANALYZER.enableCustomDictionary(true); // 使用用词典分词。
        System.out.println(NLPTokenizer.segment("什么是基尔霍夫电压定律"));
//        System.out.println(NLPTokenizer.analyze("我救的不是他，是多年前一个寒夜里，在篝火与烈酒中，想仗剑江湖的少年。").translateLabels());
    }
}

