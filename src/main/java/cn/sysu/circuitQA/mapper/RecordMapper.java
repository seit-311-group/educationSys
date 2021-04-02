package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface RecordMapper {
    List<Record> findAll();
    void save(Record record);
    String getAllQuestion();
}
