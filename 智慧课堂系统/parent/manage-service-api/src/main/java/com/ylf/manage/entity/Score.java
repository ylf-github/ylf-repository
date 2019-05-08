package com.ylf.manage.entity;

import java.io.Serializable;

/**
 * 经验值实体
 * @Author ylf
 * @Time 2019/2/27
 */
public class Score implements Serializable {
    private Integer num;

    private String uName;

    private String uEmail;

    private String cId;

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}