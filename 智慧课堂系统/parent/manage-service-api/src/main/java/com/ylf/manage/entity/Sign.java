package com.ylf.manage.entity;

import java.util.List;

/**
 * 签到表
 * @Author ylf
 * @Time 2019/2/22
 */
public class Sign {
    private String sId;    //签到表id

    private String cId;    //签到课程

    private String des;    //签到描述

    private String time;   //创建时间

    private List<Signer> signers; //签到者

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public List<Signer> getSigners() {
        return signers;
    }

    public void setSigners(List<Signer> signers) {
        this.signers = signers;
    }
}