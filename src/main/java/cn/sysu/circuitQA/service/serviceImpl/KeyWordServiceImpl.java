package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.mapper.keyWordMapper;
import cn.sysu.circuitQA.pojo.keyWord;
import cn.sysu.circuitQA.pojo.keyWordExample;
import cn.sysu.circuitQA.service.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyWordServiceImpl implements KeyWordService {
    @Autowired
    private cn.sysu.circuitQA.mapper.keyWordMapper keyWordMapper;

    @Override
    public List<keyWord> importKeyWords(){
        keyWordExample keyWordExample = new keyWordExample();
        keyWordExample.Criteria criteria = keyWordExample.createCriteria();
        return keyWordMapper.selectByExample(keyWordExample);
    };

    @Override
    public String getIDByKeyWord(String keyword){
        keyWordExample keyWordExample = new keyWordExample();
        keyWordExample.Criteria criteria = keyWordExample.createCriteria();
        criteria.andKeywordEqualTo(keyword);
        keyWord keyWord = keyWordMapper.selectByExample(keyWordExample).get(0);
        return keyWord.getQuestionids();
    };
    
}
