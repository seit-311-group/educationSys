package cn.sysu.educationSys.service;


import org.springframework.ui.Model;

public interface RecordService {
    void wordsSave(String query,String question, String answer);

    void pagingAndShow(String search,String pageNumber, Model model);

    void questionSave(String question);
}
