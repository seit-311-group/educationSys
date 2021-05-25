package cn.sysu.circuitQA.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

public interface AddQAService {

    String pagingAndShow(String search);

    String addQA(String addStr);

    void addKeyword(String question, String questionId);
}
