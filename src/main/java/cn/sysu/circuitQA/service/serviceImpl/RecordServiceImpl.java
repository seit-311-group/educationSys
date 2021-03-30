package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.pojo.keyWord;
import cn.sysu.circuitQA.pojo.keyWordExample;
import cn.sysu.circuitQA.pojo.record;
import cn.sysu.circuitQA.pojo.recordExample;
import cn.sysu.circuitQA.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private cn.sysu.circuitQA.mapper.recordMapper recordMapper;

    public void addRecord(String query, String question, String answer, String success){
        record record = new record();
        record.setQuestion(question);
        record.setAnswer(answer);
        record.setSuccess(success);
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String nowDate = format.format(now);
        record.setDate(nowDate);
        record.setQuery(query);
        recordMapper.insert(record);
    };

    public String findRecord(String date){
        recordExample recordExample = new recordExample();
        recordExample.Criteria criteria = recordExample.createCriteria();
        String day = date.substring(0,8);
        criteria.andDateGreaterThanOrEqualTo(day);
        List<record> records = recordMapper.selectByExample(recordExample);

        String res = "";
        for (int i = 0; i < records.size(); i++){
            res = res + " " + records.get(i).getQuery();
        }
        return (res.length() == 0) ? null : res.substring(1);
    }
}
