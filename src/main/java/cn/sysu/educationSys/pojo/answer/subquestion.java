package cn.sysu.educationSys.pojo.answer;

public class subquestion {
    private Integer id;

    private String optionid;

    private String content;

    private Integer answer;

    private boolean listEquation;

    public boolean isListEquation() {
        return listEquation;
    }

    public void setListEquation(boolean listEquation) {
        this.listEquation = listEquation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptionid() {
        return optionid;
    }

    public void setOptionid(String optionid) {
        this.optionid = optionid == null ? null : optionid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}