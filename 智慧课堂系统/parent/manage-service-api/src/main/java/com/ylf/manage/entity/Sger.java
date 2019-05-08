package com.ylf.manage.entity;

/**
 * 签到者信息
 * @Author ylf
 * @Time 2019/3/21
 */
public class Sger {


    private String des;       //签到描述

    private String sign;      //是否签到

    private String time;      //此次签到创建的时间


    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}