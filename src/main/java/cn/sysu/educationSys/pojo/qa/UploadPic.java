package cn.sysu.educationSys.pojo.qa;

import java.sql.Time;
import java.util.Objects;

public class UploadPic {
    private String studentId;

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UploadPic upLoadPic = (UploadPic) o;
        return Objects.equals(studentId, upLoadPic.studentId) &&
                Objects.equals(description, upLoadPic.description) &&
                Objects.equals(time, upLoadPic.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, description, time);
    }

    @Override
    public String toString() {
        return "UpLoadPic{" +
                "studentId='" + studentId + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    private Time time;
}
