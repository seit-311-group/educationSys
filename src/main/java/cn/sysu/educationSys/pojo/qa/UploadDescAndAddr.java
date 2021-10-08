package cn.sysu.educationSys.pojo.qa;

import java.util.Objects;

public class UploadDescAndAddr {
    private String description;

    @Override
    public String toString() {
        return "UploadDescAndAddr{" +
                "description='" + description + '\'' +
                ", picAddress='" + picAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UploadDescAndAddr that = (UploadDescAndAddr) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(picAddress, that.picAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, picAddress);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress;
    }

    private String picAddress;

}
