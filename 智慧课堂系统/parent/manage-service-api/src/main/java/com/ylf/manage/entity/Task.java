package com.ylf.manage.entity;

import java.io.Serializable;

/**
 * 任务实体
 */
public class Task implements Serializable {
    private String tId;  //主键

    private String cId;  //所属课程号

    private String tTitle; //标题

    private String tContent;  //任务内容

    private String tName;    //发布者

    private String tTime;   //创建时间

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    public String gettContent() {
        return tContent;
    }

    public void settContent(String tContent) {
        this.tContent = tContent;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettTime() {
        return tTime;
    }

    public void settTime(String tTime) {
        this.tTime = tTime;
    }
}