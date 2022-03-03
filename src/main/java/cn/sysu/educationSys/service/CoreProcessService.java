package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.qa.circuitQa;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CoreProcessService {
    public circuitQa analysis(String query) throws IOException;

    public Map<circuitQa, Float> analysisTop5(String query) throws IOException;

    public List<circuitQa> extractCandidates(String question) throws IOException;

    public List<String> extract(String question) throws IOException;

    public String subQuery(String ques) throws IOException, InterruptedException;

    public String subQuestion(String query) throws IOException;
}
