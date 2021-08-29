package cn.sysu.educationSys.pojo;

public class question {
    private Integer id;

    private String description;

    private String pointid;

    private String subquesid;

    private String answer;

    private String analysis;

    private String addpicture;

    private String changepicture;

    private Double passrate;

    private String keyword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPointid() {
        return pointid;
    }

    public void setPointid(String pointid) {
        this.pointid = pointid == null ? null : pointid.trim();
    }

    public String getSubquesid() {
        return subquesid;
    }

    public void setSubquesid(String subquesid) {
        this.subquesid = subquesid == null ? null : subquesid.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }

    public String getAddpicture() {
        return addpicture;
    }

    public void setAddpicture(String addpicture) {
        this.addpicture = addpicture == null ? null : addpicture.trim();
    }

    public String getChangepicture() {
        return changepicture;
    }

    public void setChangepicture(String changepicture) {
        this.changepicture = changepicture == null ? null : changepicture.trim();
    }

    public Double getPassrate() {
        return passrate;
    }

    public void setPassrate(Double passrate) {
        this.passrate = passrate;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
}