package cn.sysu.educationSys.pojo.student;

import java.sql.Timestamp;
import java.util.Objects;

public class RegisterRecord {
    private long id;

    private Timestamp time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterRecord that = (RegisterRecord) o;
        return id == that.id &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }

    @Override
    public String toString() {
        return "LoginRecord{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public RegisterRecord(long id, Timestamp time) {
        this.id = id;
        this.time = time;
    }
}
