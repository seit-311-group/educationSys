package cn.sysu.educationSys.service;

import cn.sysu.educationSys.pojo.student.Student;

import java.util.List;

public interface StudentService {
    Student login(Long id, String password);

    void loginRecord(Long id);

    Student regist(Long id, String name, String password, String classandgrade);

    void registerRecord(Long id);


    void updateQueryKeywords(Long studentId, String queryKeywords);

    Student findById(Long id);

    String findPswById(Long id);

    List<Student> findAll();

    String[] findPassedQuestion(Long studentId);

    void saveQuestionIdPointIdAndPassedQuestion(String points);

    String questionIsPassed(String questionId, String newPoints);

    void updatePointsAndPassedQuestion(String points, String questionId);

    String passedQuestion(Student student, String questionId);


}
