package cn.sysu.educationSys.pojo.qa;

public class keyWord {
    private String keyword;

    private String questionids;

    private String anIDs;

    public String getAnIDs() {
        return anIDs;
    }

    public void setAnIDs(String anIDs) {
        this.anIDs = anIDs;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getQuestionids() {
        return questionids;
    }

    public void setQuestionids(String questionids) {
        this.questionids = questionids == null ? null : questionids.trim();
    }
}