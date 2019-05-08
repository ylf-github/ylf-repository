package com.ylf.manage.idao;

import com.ylf.manage.entity.Sign;

import java.util.List;


public interface Sign_idao {
    int add(Sign sign);    //添加签到
    int del(String s_id);  //删除签到
    Sign getOne(String s_id);//查找特定签到
    List<Sign> getCourseSign(String c_id); //查找某课程所有签到
}
