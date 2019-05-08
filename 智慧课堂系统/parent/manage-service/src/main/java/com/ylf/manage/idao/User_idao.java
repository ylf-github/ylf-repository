package com.ylf.manage.idao;

import com.ylf.manage.entity.Uemail;
import com.ylf.manage.entity.User;

import java.util.List;

public interface User_idao {
      int add(User user);          //添加用户
      int upd(User user);          //更新用户
      int del(String id);          //删除用户
      List<User> findAll();        //查找所有用户
      User findOne(String id);     //查找指定用户
      int updId(Uemail uemail);    //更新用户邮箱
      List<User> getIsSignUser(String s_id);  //查找已签到用户
      List<User> getNotSignUser(String s_id); //查找未签到用户
      int updPass(User user);        //忘记密码
}
