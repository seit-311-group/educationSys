package cn.sysu.educationSys.pojo.qa;

public class KeywordsAll {
    private Integer id;

    private String keyword;

    private Integer times;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}