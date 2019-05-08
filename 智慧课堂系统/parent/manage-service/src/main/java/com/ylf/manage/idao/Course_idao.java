package com.ylf.manage.idao;

import com.ylf.manage.entity.Course;
import com.ylf.manage.entity.User;

import java.util.List;


public interface Course_idao {
      int add(Course course);       //添加课程
      Course findOne(String id);    //查找一门课程
      int del(String id);           //删除一门课程
      List<User> findAllJoin(String c_id);     //查找加入这门课程的用户
}
