package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.Record;

import java.util.List;
import java.util.Map;

public interface RecordMapperCustom extends RecordMapper {
    List<Record> findAll();

    List<String> getAllQuery();

    int getCount(String search);

    List<Record> pageList(Map map);
}
