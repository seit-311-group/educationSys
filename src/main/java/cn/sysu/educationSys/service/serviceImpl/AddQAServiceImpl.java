package cn.sysu.educationSys.service.serviceImpl;


import cn.sysu.educationSys.pojo.qa.circuitQa;
import cn.sysu.educationSys.pojo.qa.keyWord;
import cn.sysu.educationSys.service.AddQAService;
import cn.sysu.educationSys.service.CircuitQAService;
import cn.sysu.educationSys.service.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static cn.sysu.educationSys.service.serviceImpl.CoreProcessServiceImpl.keyWords;


@Service
public class AddQAServiceImpl implements AddQAService {
    public static List<circuitQa> circuitQaList;

    @Autowired
    CircuitQAService circuitQAService;

    @Autowired
    cn.sysu.educationSys.mapper.circuitQaMapper circuitQaMapper;

    @Autowired
    CoreProcessServiceImpl coreProcessServiceImpl;

    @Autowired
    KeyWordService keyWordService;


    /**
     * 找到搜索后的问题 使用
     * @param search
     */
    @Override
    public String pagingAndShow(String search) {
        StringBuffer sb = new StringBuffer();
        List<circuitQa> circuitQaList = circuitQAService.importQuestions();
        if(!search.equals("")){
            for (circuitQa circuitQa :circuitQaList){
                if(circuitQa.getQuestion().contains(search)){
                    sb.append(circuitQa.getQuestion() + "@");
                }
            }
        }else {
            for (circuitQa circuitQa :circuitQaList){
                    sb.append(circuitQa.getQuestion() + "@");
            }
        }
        if (sb.length() == 0){
            sb.append("无搜索结果");
        }else{
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }

    @Override
    public String addQA(String addStr) {
        circuitQaList = circuitQAService.importQuestions();
        circuitQa addCircuitQa = new circuitQa();
        String[] strings = addStr.split(",");       // 以逗号分隔每个指令 添加的问题或者答案中逗号必须用中文的 不然报错
        String childrenId = "";
        String fatherId = "";
        String question = "";
        String answer = "";
        for (String string : strings) {     // 遍历每个指令
            String[] instructs = string.split("@");
            for (String instruct : instructs) {
                System.out.println(instruct);
            }
            String instruct = instructs[0];
            String instruct1 = instructs[1];
            if(instruct.equals("fa")){
                childrenId += circuitQAService.findIdByQuestion(instruct1,circuitQaList).get("questionId") + " ";
            }else if(instruct.equals("ch")){
                fatherId += circuitQAService.findIdByQuestion(instruct1,circuitQaList).get("questionId") + " ";
            }else if(instruct.equals("question")){
                question = instruct1;
                if(circuitQAService.findIdByQuestion(question,circuitQaList).get("questionId") != null){
                    return "请勿重复添加问题";
                }
                addCircuitQa.setQuestion(question);
            }else if(instruct.equals("answer")){
                answer = instruct1;
                addCircuitQa.setAnswer(answer);
            }
        }
        addCircuitQa.setChildid(childrenId);
        addCircuitQa.setParentid(fatherId);
        circuitQaMapper.insert(addCircuitQa);

        circuitQaList = circuitQAService.importQuestions();
        System.out.println(question);
        String questionId = (String) circuitQAService.findIdByQuestion(question,circuitQaList).get("questionId");
        System.out.println(questionId);
        // 添加子问题的父节点
        if(!childrenId.equals("")){
            String[] childrenIds = childrenId.split(" ");
            for (String id : childrenIds) {
                String setParentId = "";
                circuitQa questionByIdObj = circuitQAService.findQuestionById(id);
                System.out.println();
                if (questionByIdObj.getParentid() != null){
                    setParentId += questionByIdObj.getParentid() + " " + questionId;
                }else{
                    setParentId += questionId;
                }
                circuitQAService.updateQuestion(Integer.parseInt(id), questionByIdObj.getChildid(), setParentId);
            }
        }

        if(!fatherId.equals("")){
            String[] parentIds = fatherId.split(" ");
            for (String id : parentIds) {
                String setChildId = "";
                circuitQa questionById = circuitQAService.findQuestionById(id);
                if (questionById.getChildid() != null){
                    setChildId += questionById.getChildid() + " " + questionId;
                }else{
                    setChildId += questionId;
                }
                circuitQAService.updateQuestion(Integer.parseInt(id), setChildId, questionById.getParentid());
            }
        }

        addKeyword(question,questionId);
        return "添加成功";
    }

    @Override
    public void addKeyword(String question,String questionID) {
        // String keyword = coreProcessServiceImpl.extract(question);
        String keyword = "";
        keyWord keyWordObj = new keyWord();
        for (keyWord key : keyWords) {
            if(key.getKeyword().equals(keyword)){
                keyWordObj = key;
                break;
            }
        }
        String questionids = keyWordObj.getQuestionids();
        if(questionids != null){
            questionids += "," + questionID;
        }else{
            questionids += questionID;
        }
        keyWordService.UpdateKeyword(keyword, questionids);
    }
}
