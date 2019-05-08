package com.ylf.manage.iservice;

import com.ylf.manage.entity.Course;
import com.ylf.manage.entity.User;

import java.util.List;

public interface Course_iserv {
    int add(Course course,String u_id);       //添加课程
    List<User> findAllJoinUser(String id);   //查找所有加入的学生
    int del(String id);           //删除一门课程
<<<<<<< HEAD
<<<<<<< HEAD
=======
    Course getOne(String c_id);   //查找一门课程
>>>>>>> zhkt-ok
=======
    Course getOne(String c_id);   //查找一门课程
>>>>>>> by_19/5/8
}
