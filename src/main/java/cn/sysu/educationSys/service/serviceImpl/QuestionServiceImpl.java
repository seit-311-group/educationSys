package cn.sysu.educationSys.service.serviceImpl;

import cn.sysu.educationSys.config.ConfigProperties;
import cn.sysu.educationSys.mapper.UploadPicMapper;
import cn.sysu.educationSys.pojo.answer.*;
import cn.sysu.educationSys.pojo.qa.UploadPic;
import cn.sysu.educationSys.pojo.qa.question;
import cn.sysu.educationSys.pojo.qa.questionExample;
import cn.sysu.educationSys.service.AnswerFunctionRecordsService;
import cn.sysu.educationSys.service.AnswerRecordsService;
import cn.sysu.educationSys.service.QuestionService;
import cn.sysu.educationSys.utils.HttpUtil;
import cn.sysu.educationSys.utils.StaticVariables;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final static Logger logger = Logger.getLogger(QuestionServiceImpl.class);
    @Autowired
    private cn.sysu.educationSys.mapper.questionMapper questionMapper;

    @Autowired
    private cn.sysu.educationSys.mapper.pointMapper pointMapper;

    @Autowired
    private cn.sysu.educationSys.mapper.subquestionMapper subquestionMapper;

    @Autowired
    private cn.sysu.educationSys.mapper.option_tMapper option_tMapper;

    @Autowired
    AnswerRecordsService answerRecordsService;

    @Autowired
    ConfigProperties configProperties;

    @Autowired
    HttpUtil httpUtil;

    @Autowired
    UploadPicMapper uploadPicMapper;

    @Autowired
    AnswerFunctionRecordsService answerFunctionRecordsService;

    @Override
    public List<question> getQuestionsByID(String ID) {
        questionExample questionExample = new questionExample();
        questionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIdEqualTo(Integer.valueOf(ID));
        return questionMapper.selectByExample(questionExample);
    }

    @Override
    public List<subquestion> getSubquestionsByID(String ID) {
        subquestionExample subquestionExample = new subquestionExample();
        subquestionExample.Criteria criteria = subquestionExample.createCriteria();
        criteria.andIdEqualTo(Integer.valueOf(ID));
        return subquestionMapper.selectByExample(subquestionExample);
    }

    @Override
    public List<point> getPointsByID(String ID) {
        pointExample pointExample = new pointExample();
        pointExample.Criteria criteria = pointExample.createCriteria();
        criteria.andIdEqualTo(Integer.valueOf(ID));
        return pointMapper.selectByExample(pointExample);
    }

    @Override
    public List<option_t> getOptionsByID(String ID) {
        option_tExample option_tExample = new option_tExample();
        option_tExample.Criteria criteria = option_tExample.createCriteria();
        criteria.andIdEqualTo(Integer.valueOf(ID));
        return option_tMapper.selectByExample(option_tExample);
    }

    /**
     * 找到所有的问题对象
     * @return 问题对象
     */
    @Override
    public String findAllQuestion() {
        List<question> questions = findAll();
        String res = "";
        for (question question : questions) {
            res += question.getDescription() + "@" + question.getKeyword() + "@" + question.getPassrate() + "@";
        }
        return res;
    }

    @Override
    public List<question> findAll() {
        questionExample questionExample = new questionExample();
        List<question> questions = questionMapper.selectByExample(questionExample);
        return questions;
    }

    @Override
    public int findAllNums() {
        List<question> all = findAll();
        return all.size();
    }

    /**
     * 根据知识点找到知识点id
     * @param content
     * @return
     */
    @Override
    public String findPointByContent(String content) {
        pointExample pointExample = new pointExample();
        cn.sysu.educationSys.pojo.answer.pointExample.Criteria criteria = pointExample.createCriteria();
        criteria.andContentEqualTo(content);
        point point = new point();
        List<cn.sysu.educationSys.pojo.answer.point> points = pointMapper.selectByExample(pointExample);
        return points.get(0).getId().toString();
    }

    @Override
    public void passRateUpdate(String errorOptionsCount) {
        String[] split = errorOptionsCount.split("@");
        List<question> questionsByID = getQuestionsByID(split[0]);
        question question = questionsByID.get(0);
        int sumOptions = countAllOption(split[0],question);
        int errorOptions = Integer.parseInt(split[1]);
        int correctOptions = sumOptions - errorOptions;
        DecimalFormat df = new DecimalFormat("0.00");
        double oneRate = Double.parseDouble(df.format((double) correctOptions / sumOptions));
        int n = answerRecordsService.countRecordsByQuestionId(split[0]);

        questionExample questionExample = new questionExample();
        cn.sysu.educationSys.pojo.qa.questionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIdEqualTo(question.getId());
        question question1 = new question();
        if(null == question.getPassrate()|| question.getPassrate().equals(0)){
            question1.setPassrate(oneRate);
        }else{
            double newPassRate = Double.parseDouble(df.format((double)(((n - 1) * question.getPassrate() + oneRate)/n)));
            question1.setPassrate(newPassRate);
        }
        questionMapper.updateByExampleSelective(question1,questionExample);
    }

    @Override
    public int countAllOption(String questionId, question question) {
        String subQuestionId = question.getSubquesid();
        String[] split = subQuestionId.split(",");
        int countSubquesitons = split.length;
        int count = 0;
        for (String s : split) {
            List<subquestion> subquestionsByID = getSubquestionsByID(s);
            count += subquestionsByID.get(0).getOptionid().split(",").length;
        }

        return count-countSubquesitons;
    }

    /**
     * 上传图片到本地
     * @param picture
     */
    @Override
    public String upLoadPic(MultipartFile[] picture, Long studentId, String description) {
        Timestamp now = new Timestamp(new Date().getTime());

        if(picture.length == 0){
            logger.info("用户没有上传图片");
            uploadPicMapper.insertUpload(new UploadPic(studentId, description, "", now));

        }else {
            logger.info("您已进入图片上传服务,用户一共要上传" + picture.length + "张图片");
            //获取文件在服务器的储存位置
            String path = configProperties.getPic();
            logger.info("文件的保存路径：" + path);

            for (int i = 0; i < picture.length; i++) {
                logger.info("上传第" + (i+1) + "张图片中......");
                File filePath = new File(path);
                if (!filePath.exists() && !filePath.isDirectory()) {
                    logger.info("目录不存在，创建目录:" + filePath);
                    filePath.mkdir();
                }
                //获取原始文件名称(包含格式)
                String originalFileName = picture[i].getOriginalFilename();
                logger.info("原始文件名称：" + originalFileName);

                //获取文件类型，以最后一个`.`为标识
                String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                logger.info("文件类型：" + type);
                //获取文件名称（不包含格式）
                String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

                String fileName = UUID.randomUUID().toString().replaceAll("-","") + name + "." + type;
                logger.info("新文件名称：" + fileName);

                //在指定路径下创建一个文件
                File targetFile = new File(path, fileName);
                logger.info("图片地址："+path+"/"+fileName);

                uploadPicMapper.insertUpload(new UploadPic(studentId, description, path+"/"+fileName, now));
                //将文件保存到服务器指定位置
                try {
                    picture[i].transferTo(targetFile);
                    logger.info("上传成功");

                    //将文件在服务器的存储路径返回
                } catch (IOException e) {
                    logger.error("上传失败" + e);
                    e.printStackTrace();
                    return StaticVariables.UPLOAD_FALSE;
                }
            }
            logger.info("图片全部上传完毕");

        }
        return StaticVariables.UPLOAD_SUCCESS;
    }

    @Override
    public boolean isListEquation(String subQuestionId) {
        subquestion subQuestionById = subquestionMapper.getSubQuestionById(subQuestionId);
        return subQuestionById.isListEquation();
    }

    @Override
    public String findRightFunction(String subQuestionId) {
        subquestion subQuestionById = subquestionMapper.getSubQuestionById(subQuestionId);
        option_t option_t = getOptionsByID(String.valueOf(subQuestionById.getAnswer())).get(0);
        return option_t.getContent();
    }

    @Override
    public String matchFunction(AnswerFunctionRecords answerFunctionRecords) throws JsonProcessingException {
        logger.info("调用公式匹配功能");
        JSONObject jsonObject = null;
        Map<String, String> map = new HashMap<>();
        try {
            String function1 = answerFunctionRecords.getFunction1();
            String function2 = answerFunctionRecords.getFunction2();
            HashMap<String, String> params = new HashMap<>();
            params.put("function1", function1);
            params.put("function2", function2);
            String paramString = JSON.toJSONString(params);
            String url = "http://" + configProperties.getAlgorithmSeverIpAndPort() + "/functionMatch";
            String res = httpUtil.post(url, paramString);
            jsonObject = JSON.parseObject(res);
            // 问答结果存到数据库
            logger.info("保存记录到数据库中");
            String function1Simplify = jsonObject.get("function1") + "=0";
            String function2Simplify = jsonObject.get("function2") + "=0";
            String similarity = String.valueOf(jsonObject.get("similarity"));
            AnswerFunctionRecords records = new AnswerFunctionRecords(function1, function1Simplify, function2,
                    function2Simplify, Double.parseDouble(similarity), 1, new Timestamp(new Date().getTime()),
                    answerFunctionRecords.getQuestionId(), answerFunctionRecords.getSubQuestionId());
            answerFunctionRecordsService.insertAnswerFunctionRecords(records);
            logger.info("保存记录结束");

            // 封装结果
            map.put("function1Simplify", function1Simplify);
            map.put("function2Simplify", function2Simplify);
            map.put("similarity", similarity);
            logger.info("结果：" + jsonObject);
        }catch (Exception e){
            logger.error("公式匹配出错" + e);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);

        return json;
    }

}
