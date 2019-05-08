package com.ylf.manage.iservice;

import com.ylf.manage.entity.Sign;
import com.ylf.manage.entity.User;

import java.util.List;

public interface Sign_iserv {
    int add(Sign sign);   //添加签到
    int del(String s_id); //删除签到
    Sign getOne(String s_id); //查找特定签到
    List<User> findAllIsSigner(String s_id); //查找已签到的用户
    List<User> findAllNotSigner(String s_id); //查找未签到用户
    List<Sign> getCourseSignInfo(String c_id);//查特定班级的所有签到
}
