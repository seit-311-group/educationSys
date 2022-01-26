package cn.sysu.educationSys.pojo.answer;

import java.sql.Timestamp;
import java.util.Objects;

public class AnswerFunctionRecords {
    private String function1;

    private String function1Simplify;

    private String function2;

    private String function2Simplify;

    private double similarity;

    private long studentId;

    private Timestamp time;

    private int questionId;

    private int subQuestionId;

    public AnswerFunctionRecords() {
    }

    public AnswerFunctionRecords(String function1, String function1Simplify, String function2, String function2Simplify,
                                 double similarity, long studentId, Timestamp time, int questionId, int subQuestionId) {
        this.function1 = function1;
        this.function1Simplify = function1Simplify;
        this.function2 = function2;
        this.function2Simplify = function2Simplify;
        this.similarity = similarity;
        this.studentId = studentId;
        this.time = time;
        this.questionId = questionId;
        this.subQuestionId = subQuestionId;
    }

    public String getFunction1() {
        return function1;
    }

    public void setFunction1(String function1) {
        this.function1 = function1;
    }

    public String getFunction1Simplify() {
        return function1Simplify;
    }

    public void setFunction1Simplify(String function1Simplify) {
        this.function1Simplify = function1Simplify;
    }

    public String getFunction2() {
        return function2;
    }

    public void setFunction2(String function2) {
        this.function2 = function2;
    }

    public String getFunction2Simplify() {
        return function2Simplify;
    }

    public void setFunction2Simplify(String function2Simplify) {
        this.function2Simplify = function2Simplify;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getSubQuestionId() {
        return subQuestionId;
    }

    public void setSubQuestionId(int subQuestionId) {
        this.subQuestionId = subQuestionId;
    }

    @Override
    public String toString() {
        return "AnswerFunctionRecords{" +
                "function1='" + function1 + '\'' +
                ", function1Simplify='" + function1Simplify + '\'' +
                ", function2='" + function2 + '\'' +
                ", function2Simplify='" + function2Simplify + '\'' +
                ", similarity=" + similarity +
                ", studentId=" + studentId +
                ", time=" + time +
                ", questionId=" + questionId +
                ", subQuestionId=" + subQuestionId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerFunctionRecords that = (AnswerFunctionRecords) o;
        return Double.compare(that.similarity, similarity) == 0 &&
                studentId == that.studentId &&
                questionId == that.questionId &&
                subQuestionId == that.subQuestionId &&
                Objects.equals(function1, that.function1) &&
                Objects.equals(function1Simplify, that.function1Simplify) &&
                Objects.equals(function2, that.function2) &&
                Objects.equals(function2Simplify, that.function2Simplify) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(function1, function1Simplify, function2, function2Simplify, similarity, studentId, time, questionId, subQuestionId);
    }
}
