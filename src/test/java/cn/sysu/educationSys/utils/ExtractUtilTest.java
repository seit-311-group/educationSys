package cn.sysu.educationSys.utils;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExtractUtilTest {
    @Autowired
    ExtractUtil extractUtil;
    @Test
    public void stopWordsTest() throws IOException {
        NLPTokenizer.ANALYZER.enableCustomDictionary(true);
        String s = extractUtil.removalOfStopWords("什么是kvl");
        List<Term> seg = NLPTokenizer.segment(s);        //分词
        for (Term term : seg) {
            System.out.println(term.word);
        }


    }
}
