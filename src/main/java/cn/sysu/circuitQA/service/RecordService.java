package cn.sysu.circuitQA.service;

public interface RecordService {
    void addRecord(String query, String question, String answer, String success);
    String findRecord(String date);
}
