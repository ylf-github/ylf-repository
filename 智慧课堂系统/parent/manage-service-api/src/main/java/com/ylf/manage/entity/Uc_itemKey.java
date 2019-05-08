package com.ylf.manage.entity;
/**
 * 用户-课程实体
 * @Author ylf
 * @Time 2019/2/19
 */
public class Uc_itemKey {
    private String uEmail;   //用户id

    private String cId;      //课程id

    private String cType;    //相关对应关系

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

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
}