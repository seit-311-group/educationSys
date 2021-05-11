package cn.sysu.circuitQA.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

public interface AddQAService {

    List pagingAndShow(String search,Model model);
}
