package cn.sysu.educationSys.service;

public interface AddQAService {

    String pagingAndShow(String search);

    String addQA(String addStr);

    void addKeyword(String question, String questionId);
}
