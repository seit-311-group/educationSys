package cn.sysu.educationSys.pojo.answer;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * 可以使用继承而不是组合
 */
public class AnswerFunctionFeedback extends AnswerFunctionRecords{
    private String latestFunction;

    public String getLatestFunction() {
        return latestFunction;
    }

    public void setLatestFunction(String latestFunction) {
        this.latestFunction = latestFunction;
    }

    public AnswerFunctionFeedback() {
        super(); // 无参构造的
    }

    public AnswerFunctionFeedback(String function1, String function1Simplify, String function2, String function2Simplify, double similarity, long studentId, Timestamp time, int questionId, int subQuestionId) {
        super(function1, function1Simplify, function2, function2Simplify, similarity, studentId, time, questionId, subQuestionId);
    }

    public AnswerFunctionFeedback(String latestFunction) {
        this.latestFunction = latestFunction;
    }

    public AnswerFunctionFeedback(String function1, String function1Simplify, String function2, String function2Simplify, double similarity, long studentId, Timestamp time, int questionId, int subQuestionId, String latestFunction) {
        super(function1, function1Simplify, function2, function2Simplify, similarity, studentId, time, questionId, subQuestionId);
        this.latestFunction = latestFunction;
    }

    @Override
    public String toString() {
        return "AnswerFunctionFeedback{" +
                "latestFunction='" + latestFunction + '\'' +
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
        if (!super.equals(o)) return false;
        AnswerFunctionFeedback that = (AnswerFunctionFeedback) o;
        return Objects.equals(latestFunction, that.latestFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), latestFunction);
    }
}
