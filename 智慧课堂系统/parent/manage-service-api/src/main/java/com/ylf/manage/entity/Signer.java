package com.ylf.manage.entity;

/**
 * 签到者
 * @Author ylf
 * @Time 2019/2/22
 */
public class Signer {
    private String uEmail;         //签到者id

    private String sId;            //外键

    private String sTime;          //签到时间

    private String cId;            //签到课程

    private String sType;          //是否签到

    private String createTime;     //此次签到创建的时间

    private Sign sign;             //签到

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}