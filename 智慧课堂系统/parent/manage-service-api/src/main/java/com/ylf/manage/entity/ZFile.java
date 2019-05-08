package com.ylf.manage.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * 课程实体
 * @Author ylf
 * @Time 2019/2/19
 */
public class ZFile implements Serializable {

    private String cName;      //课程名

    private String cClass;     //班级

    private String user;       //用户

    private MultipartFile cImg;    //封面


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


    public MultipartFile getcImg() {
        return cImg;
    }

    public void setcImg(MultipartFile cImg) {
        this.cImg = cImg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
