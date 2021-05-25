package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.mapper.KeywordtimesallMapperCustom;
import cn.sysu.circuitQA.pojo.KeywordsAll;
import cn.sysu.circuitQA.pojo.KeywordsAllExample;
import cn.sysu.circuitQA.service.KeywordtimesallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KeywordtimesallServiceImpl implements KeywordtimesallService {
    @Autowired
    KeywordtimesallMapperCustom keywordtimesallMapperCustom;


    @Override
    public void keywordUpdate(String keyword, int num) {
        KeywordsAllExample example = new KeywordsAllExample();
        KeywordsAllExample.Criteria criteria = example.createCriteria();
        criteria.andKeywordEqualTo(keyword);
        KeywordsAll keywordtimesall = new KeywordsAll();
        keywordtimesall.setTimes(num);
        keywordtimesallMapperCustom.updateByExampleSelective(keywordtimesall,example);
    }

    @Override
    public void keywordInsertOrUpdate(String keyword) {
        List<String> allKeywords = keywordtimesallMapperCustom.getAllKeywords();
        if(allKeywords.contains(keyword)){
            int times = keywordtimesallMapperCustom.getTimesBykeyword(keyword);
            times += 1;
            keywordUpdate(keyword,times);
        }else {
            KeywordsAll keywordtimesall = new KeywordsAll();
            keywordtimesall.setTimes(1);
            keywordtimesall.setKeyword(keyword);
            keywordtimesallMapperCustom.insert(keywordtimesall);
        }
    }




}
