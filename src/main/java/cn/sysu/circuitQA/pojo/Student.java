package cn.sysu.circuitQA.pojo;

public class Student {
    private Long id;

    private String studentname;

    private String password;

    private String classandgrade;

    private String querykeywords;

    private String answerkeywords;

    private String passedquestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getClassandgrade() {
        return classandgrade;
    }

    public void setClassandgrade(String classandgrade) {
        this.classandgrade = classandgrade == null ? null : classandgrade.trim();
    }

    public String getQuerykeywords() {
        return querykeywords;
    }

    public void setQuerykeywords(String querykeywords) {
        this.querykeywords = querykeywords == null ? null : querykeywords.trim();
    }

    public String getAnswerkeywords() {
        return answerkeywords;
    }

    public void setAnswerkeywords(String answerkeywords) {
        this.answerkeywords = answerkeywords == null ? null : answerkeywords.trim();
    }

    public String getPassedquestion() {
        return passedquestion;
    }

    public void setPassedquestion(String passedquestion) {
        this.passedquestion = passedquestion == null ? null : passedquestion.trim();
    }
}