package cn.sysu.educationSys.mapper;

import cn.sysu.educationSys.pojo.Records;

import java.util.List;
import java.util.Map;

public interface RecordMapperCustom extends RecordsMapper {
    List<Records> findAll();

    List<String> getAllQuery();

    int getCount(Map map);

    List<Records> pageList(Map map);

    int getCountAll(String search);

    List<Records> pageListAll(Map map);
}
