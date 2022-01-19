package cn.sysu.educationSys.pojo.answer;

import java.sql.Timestamp;
import java.util.Objects;

public class FunctionMatchRecords {
    String function1;

    String function2;

    String function1Simplify;

    String function2Simplify;

    double similarity;

    long studentId;

    Timestamp time;

    public FunctionMatchRecords() {
    }

    public String getFunction1() {
        return function1;
    }

    public void setFunction1(String function1) {
        this.function1 = function1;
    }

    public String getFunction2() {
        return function2;
    }

    public void setFunction2(String function2) {
        this.function2 = function2;
    }

    public String getFunction1Simplify() {
        return function1Simplify;
    }

    public void setFunction1Simplify(String function1Simplify) {
        this.function1Simplify = function1Simplify;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionMatchRecords that = (FunctionMatchRecords) o;
        return Double.compare(that.similarity, similarity) == 0 &&
                studentId == that.studentId &&
                Objects.equals(function1, that.function1) &&
                Objects.equals(function2, that.function2) &&
                Objects.equals(function1Simplify, that.function1Simplify) &&
                Objects.equals(function2Simplify, that.function2Simplify) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(function1, function2, function1Simplify, function2Simplify, similarity, studentId, time);
    }

    @Override
    public String toString() {
        return "FunctionMatchRecords{" +
                "function1='" + function1 + '\'' +
                ", function2='" + function2 + '\'' +
                ", function1Simplify='" + function1Simplify + '\'' +
                ", function2Simplify='" + function2Simplify + '\'' +
                ", similarity=" + similarity +
                ", studentId=" + studentId +
                ", time=" + time +
                '}';
    }
}
