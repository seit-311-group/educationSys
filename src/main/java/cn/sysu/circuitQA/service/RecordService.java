package cn.sysu.circuitQA.service;


import org.springframework.ui.Model;

public interface RecordService {
    void wordsSave(String query,String question, String answer);

    void pagingAndShow(String seatch,String pageNumber, Model model);
}
