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
        List<Term> termList = StandardTokenizer.segment("什么是电路的过渡过程");
        for (Term term : termList)
        {
            System.out.println(term.word);
        }
        String content = "什么是电路的过渡过程";
        List<String> keywordList = HanLP.extractKeyword(content, 2);
        System.out.println(keywordList);
    }
}

