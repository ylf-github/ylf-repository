package com.ylf.manage.entity;

/**
 * 避免经验值重复添加
 */
public class RepScore {
    private String rId;    //资源标识符

    private String uEmail; //用户标识符

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }
}