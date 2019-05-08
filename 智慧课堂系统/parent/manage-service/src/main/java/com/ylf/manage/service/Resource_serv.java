package com.ylf.manage.service;

import com.ylf.manage.entity.Resource;
import com.ylf.manage.idao.Resource_idao;
import com.ylf.manage.iservice.Resource_iserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Resource_serv implements Resource_iserv {
    @Autowired
    private Resource_idao dao;

    public int add(Resource resource) {
        return dao.add(resource);
    }

    public int del(String r_id) {
        return dao.del(r_id);
    }

    public List<Resource> findAllCourseResource(String c_id) {
        return dao.findAllCourseResource(c_id);
    }
}
