package cn.sysu.educationSys.service.serviceImpl;

import cn.sysu.educationSys.pojo.qa.keyWord;
import cn.sysu.educationSys.pojo.qa.keyWordExample;
import cn.sysu.educationSys.service.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyWordServiceImpl implements KeyWordService {
    @Autowired
    private cn.sysu.educationSys.mapper.keyWordMapper keyWordMapper;

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
        keyWord keyWord = null;
        try {
            keyWord = keyWordMapper.selectByExample(keyWordExample).get(0);
            return keyWord.getQuestionids();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据关键词更新关键词对应的问题
     * @param keyword
     * @param questionId
     */
    @Override
    public void UpdateKeyword(String keyword, String questionId) {
        keyWordExample keyWordExample = new keyWordExample();
        cn.sysu.educationSys.pojo.qa.keyWordExample.Criteria criteria = keyWordExample.createCriteria();
        criteria.andKeywordEqualTo(keyword);
        keyWord keyWordObj = new keyWord();
        keyWordObj.setQuestionids(questionId);
        keyWordMapper.updateByExampleSelective(keyWordObj, keyWordExample);
    }

    
}
