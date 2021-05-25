package cn.sysu.circuitQA.mapper;

import cn.sysu.circuitQA.pojo.Records;

import java.util.List;
import java.util.Map;

public interface RecordMapperCustom extends RecordsMapper {
    List<Records> findAll();

    List<String> getAllQuery();

    int getCount(String search);

    List<Records> pageList(Map map);
}
