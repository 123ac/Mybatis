package com.hjl.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//使用二级缓存的实体类必须实现序列化接口Serializable
public class Student implements Serializable {
    private int id;
    private int userId;
    private String school;
    private String className;

    private List<UserInfo> userInfoArrayList=new ArrayList<>();

    public List<UserInfo> getUserInfoArrayList() {
        return userInfoArrayList;
    }

    public void setUserInfoArrayList(List<UserInfo> userInfoArrayList) {
        this.userInfoArrayList = userInfoArrayList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userId=" + userId +
                ", school='" + school + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
