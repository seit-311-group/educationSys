package cn.sysu.educationSys.service.serviceImpl;

import cn.sysu.educationSys.mapper.StudentMapper;
import cn.sysu.educationSys.mapper.StudentMapperCustom;
import cn.sysu.educationSys.pojo.AnswerRecords;
import cn.sysu.educationSys.pojo.Student;
import cn.sysu.educationSys.pojo.StudentExample;
import cn.sysu.educationSys.service.AnswerRecordsService;
import cn.sysu.educationSys.service.CookieSessionService;
import cn.sysu.educationSys.service.QuestionService;
import cn.sysu.educationSys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    private Long studentId;
    private Student studentLogin;
    private String studentName;

    @Autowired
    StudentMapperCustom studentMapperCustom;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerRecordsService answerRecordsService;

    @Autowired
    CookieSessionService cookieSessionService;

    @Override
    public Student login(Long id, String password) {
        Student studentExist = studentMapperCustom.findById(id);
        if (studentExist != null) { //用户存在
            String studentPassword = studentMapperCustom.findPswById((long)id);
            if (password.equals(studentPassword)){
                return studentExist;
            }
        }
        return null;
    }

    @Override
    public Student regist(Long id, String name, String password, String classandgrade) {
        Student student = new Student();
        student.setId(id);
        student.setStudentname(name);
        student.setPassword(password);
        student.setClassandgrade(classandgrade);
        if(studentMapperCustom.findById(id) != null){  //用户存在
            return null;
        }
        studentMapperCustom.insert(student);
        return student;
    }



    @Override
    public void updateQueryKeywords(Long studentId, String queryKeywords) {
        Student studentExist = studentMapperCustom.findById(studentId);
        String allKeywords = studentExist.getQuerykeywords();
        String res = "";


        // 例：电路,2@戴维南,1@
        if(allKeywords != null){
            if(!allKeywords.contains(queryKeywords)){
                res = allKeywords + queryKeywords + ",1@";
            }else{
                String[] splits = allKeywords.split("@");
                for (String split : splits) {
                    String[] s = split.split(",");
                    if(s[0].equals(queryKeywords)){
                        s[1] = String.valueOf(Integer.parseInt(s[1]) + 1);
                    }
                    res += s[0] + "," + s[1] + "@";
                }
            }
        }else{
            res += queryKeywords + ",1@";
        }

        Student student = new Student();
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdEqualTo(studentId);
        student.setQuerykeywords(res);
        studentMapperCustom.updateByExampleSelective(student, studentExample);
    }

    @Override
    public Student findById(Long id) {
        List<Student> all = findAll();
        for (Student student : all) {
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    @Override
    public String findPswById(Long id) {
        List<Student> all = findAll();
        for (Student student : all) {
            if (student.getId().equals(id)){
                return student.getPassword();
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        StudentExample studentExample = new StudentExample();
        return studentMapper.selectByExample(studentExample);
    }

    @Override
    public String[] findPassedQuestion(Long studentID) {
        Student student = findById(studentID);
        String[] passedQuestion;
        String studentPassedQuestion = student.getPassedquestion();
        if(studentPassedQuestion == null){
            return null;
        }else {
            passedQuestion = studentPassedQuestion.split(",");
        }

        return passedQuestion;
    }

    /**
     * 存到个人的表中
     * @param points
     */
    @Override
    public void saveQuestionIdPointIdAndPassedQuestion(String points) {
        String[] split = points.split("@");
        String questionId = split[0];
        String secondSpend = split[split.length-1];
        StringBuffer res = new StringBuffer();
        String studentResult = null;
        String recordResult = null;
        res.append(questionId + ",");
        Set set = new HashSet<>();
        for (int i = 1; i < split.length-1; i++){
            if(set.add(split[i])){
                String pointId = questionService.findPointByContent(split[i]);
                res.append(pointId + "/");
            }
        }
        int end = res.indexOf(",");

        res.deleteCharAt(res.length()-1);
        studentResult = res.append("@").toString();

        res.deleteCharAt(res.length()-1);
        res.delete(0,end+1);
        recordResult = res.toString();
        // 判断这个问题是否做过 做过的话就更新
        String result = questionIsPassed(questionId,studentResult);
        // 通过的题目字符串
        String newPassedQuestion = passedQuestion(studentLogin, questionId);
        // 更新到student表中
        updatePointsAndPassedQuestion(result, newPassedQuestion);

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

        AnswerRecords answerRecords = new AnswerRecords();
        answerRecords.setQuestionid(Integer.parseInt(questionId));
        answerRecords.setStudentname(studentName);
        answerRecords.setStudentid(studentId);
        answerRecords.setTimesubmit(dateFormat.format(date));
        answerRecords.setTimespend(secondSpend);
        answerRecords.setResult(recordResult);
        answerRecordsService.insertRecord(answerRecords);

    }

    /**
     * 判断这个问题是否做过 做过的话就更新
     * @param questionId
     * @param newPoints
     * @return 新的做错知识点的字符串
     */
    @Override
    public String questionIsPassed(String questionId, String newPoints) {
        boolean flag = true;
        String res = "";
        // 找到学生对象
        studentLogin = cookieSessionService.findStudentByCookie();
        studentId = studentLogin.getId();
        studentName = studentLogin.getStudentname();
        if (studentLogin.getAnswerkeywords() == null || studentLogin.getAnswerkeywords().equals("")){
            studentLogin.setAnswerkeywords("");
        }
        String oldQuestionIdAndPoints = studentLogin.getAnswerkeywords();
        // 看这题有没有做过
        String[] oldQuestionIdAndPointsSplit = oldQuestionIdAndPoints.split("@");
        for (String str : oldQuestionIdAndPointsSplit) {
            String[] s = str.split(",");
            if(s[0].equals(questionId)){
                res += newPoints;
                flag = false;
            }else {
                res += str + "@";
            }
        }
        if (flag){
            res += newPoints;
        }
        return res;
    }

    /**
     * 更新知识点和做过的题目
     * @param points
     */
    @Override
    public void updatePointsAndPassedQuestion(String points, String questionId) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdEqualTo(studentId);
        Student student = new Student();
        student.setAnswerkeywords(points);
        student.setPassedquestion(questionId);
        studentMapper.updateByExampleSelective(student, studentExample);
    }

    /**
     * 通过的题目字符串
     * @param student
     * @param questionId
     * @return 新的做过题目的字符串
     */
    @Override
    public String passedQuestion(Student student, String questionId) {
        String oldPassedQuestion = student.getPassedquestion();
        String res = "";
        if (oldPassedQuestion != null){
            String[] splitOldPassedQuestion = oldPassedQuestion.split(",");
            List<String> passedQuestionIdList = new ArrayList<>();
            for (String s : splitOldPassedQuestion) {
                passedQuestionIdList.add(s);
            }

            if (!passedQuestionIdList.contains(questionId)){
                passedQuestionIdList.add(questionId);
            }
            Collections.sort(passedQuestionIdList, (o1, o2) -> {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            });

            for (String s : passedQuestionIdList) {
                res += s + ",";
            }

        }else{
            res += questionId + ",";
        }
        return res;
    }


}
