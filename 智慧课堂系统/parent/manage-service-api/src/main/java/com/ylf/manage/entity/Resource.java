package com.ylf.manage.entity;

import java.io.Serializable;

/**
 * 共享资源实体
 * @Author ylf
 * @Time 2019/2/25
 */
public class Resource implements Serializable {
    private String rId;         //资源id

    private String rName;       //资源名称

    private String rCreatetime; //发布时间

    private String rScore;      //所占经验值

    private String rUrl;        //网络地址

    private String cId;         //班课id

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrCreatetime() {
        return rCreatetime;
    }

    public void setrCreatetime(String rCreatetime) {
        this.rCreatetime = rCreatetime;
    }

    public String getrScore() {
        return rScore;
    }

    public void setrScore(String rScore) {
        this.rScore = rScore;
    }

    public String getrUrl() {
        return rUrl;
    }

    public void setrUrl(String rUrl) {
        this.rUrl = rUrl;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }
}