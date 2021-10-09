package cn.sysu.educationSys.pojo.qa;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class UploadPic {
    private Long studentId;

    private String description;

    private String picAddress;

    private Timestamp time;

    public UploadPic(Long studentId, String description, String picAddress, Timestamp time) {
        this.studentId = studentId;
        this.description = description;
        this.picAddress = picAddress;
        this.time = time;
    }

    @Override
    public String toString() {
        return "UploadPic{" +
                "studentId=" + studentId +
                ", description='" + description + '\'' +
                ", picAddress='" + picAddress + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UploadPic uploadPic = (UploadPic) o;
        return Objects.equals(studentId, uploadPic.studentId) &&
                Objects.equals(description, uploadPic.description) &&
                Objects.equals(picAddress, uploadPic.picAddress) &&
                Objects.equals(time, uploadPic.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, description, picAddress, time);
    }


    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

}
