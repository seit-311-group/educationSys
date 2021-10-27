package cn.sysu.educationSys.pojo.student;

import java.util.Objects;

public class QuestionRecord {
    private long id;

    private String question;

    @Override
    public String toString() {
        return "QuestionRecord{" +
                "id=" + id +
                ", question='" + question + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionRecord that = (QuestionRecord) o;
        return id == that.id &&
                Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionRecord(long id, String question) {
        this.id = id;
        this.question = question;
    }
}
