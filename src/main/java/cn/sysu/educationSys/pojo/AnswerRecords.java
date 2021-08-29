package cn.sysu.educationSys.pojo;

public class AnswerRecords {
    private Integer questionid;

    private Long studentid;

    private String studentname;

    private String timespend;

    private String timesubmit;

    private String result;

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getTimespend() {
        return timespend;
    }

    public void setTimespend(String timespend) {
        this.timespend = timespend == null ? null : timespend.trim();
    }

    public String getTimesubmit() {
        return timesubmit;
    }

    public void setTimesubmit(String timesubmit) {
        this.timesubmit = timesubmit == null ? null : timesubmit.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}