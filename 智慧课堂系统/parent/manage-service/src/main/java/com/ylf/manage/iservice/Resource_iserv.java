package com.ylf.manage.iservice;

import com.ylf.manage.entity.Resource;

import java.util.List;

public interface Resource_iserv {
    int add(Resource resource);  //发布资源
    int del(String r_id);        //删除资源
    List<Resource> findAllCourseResource(String c_id); //返回某课程所有发布资源
}
