package com.ylf.manage.iservice;

import com.ylf.manage.entity.Course;
import com.ylf.manage.entity.Uemail;
import com.ylf.manage.entity.User;

import java.util.List;

public interface User_iserv {
    int add(User user);      //添加用户
    int upd(User user);      //更新用户
    int del(String id);      //删除用户
    List<User> findAll();    //查找所有用户
    User findOne(String id); //查找指定用户
    List<Course> findAllJoinCourse(String id);  //查找指定用户所有加入的课程
    List<Course> findAllCreateCourse(String id);//查找指定用户所有创建的课程
    int joinCourse(String u_id,String c_id);    //加入班课
    int updId(Uemail uemail);                   //更新用户邮箱
    int updPass(User user);     //忘记密码
}
