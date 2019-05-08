package com.ylf.manage.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 用户实体
 * @Author ylf
 * @Time 2019/2/19
 */
public class User implements Serializable {
    private String uEmail;        //用户邮箱

    private String uName;         //用户名

    private String uPassword;     //用户密码

    private List<Course> courses; //加入的课程

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}