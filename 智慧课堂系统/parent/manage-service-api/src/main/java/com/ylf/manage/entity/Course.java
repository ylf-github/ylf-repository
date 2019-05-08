package com.ylf.manage.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 课程实体
 * @Author ylf
 * @Time 2019/2/19
 */
public class Course implements Serializable {
    private String cId;        //课程号

    private String cName;      //课程名

    private String cClass;     //班级


    private String cImg;       //封面

    private List<User> users;  //课内学生

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcClass() {
        return cClass;
    }

    public void setcClass(String cClass) {
        this.cClass = cClass;
    }

    public String getcImg() {
        return cImg;
    }

    public void setcImg(String cImg) {
        this.cImg = cImg;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}