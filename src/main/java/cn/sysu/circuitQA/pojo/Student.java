package cn.sysu.circuitQA.pojo;

public class Student {
    private Integer id;

    private String studentname;

    private String password;

    private String classandgrade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}