package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.CircuitQA;
import cn.sysu.circuitQA.service.AddQAService;
import cn.sysu.circuitQA.service.CircuitQAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import cn.sysu.circuitQA.pojo.circuitQa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@Service
public class AddQAServiceImpl implements AddQAService {

    // @Autowired
    // Model model;

    @Autowired
    CircuitQAService circuitQAService;

    /**
     * 找到搜索后的问题 加入到model中
     * @param search
     */
    @Override
    public List pagingAndShow(String search, Model model) {
        List<circuitQa> circuitQaList = circuitQAService.importQuestions();
        List<String> searchedList = new ArrayList<>();
        if(!search.equals("")){
            for (circuitQa circuitQa :circuitQaList){
                if(circuitQa.getQuestion().contains(search)){
                    searchedList.add(circuitQa.getQuestion());
                }
            }
        }else {
            for (circuitQa circuitQa :circuitQaList){
                    searchedList.add(circuitQa.getQuestion());
            }
        }

        model.addAttribute("searchedList",searchedList);
        return searchedList;
    }
}
