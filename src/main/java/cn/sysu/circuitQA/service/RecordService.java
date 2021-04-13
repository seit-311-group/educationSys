package cn.sysu.circuitQA.service;


import org.springframework.ui.Model;

public interface RecordService {
    String wordsSave(String question);

    void pagingAndShow(String seatch,String pageNumber, Model model);
}
