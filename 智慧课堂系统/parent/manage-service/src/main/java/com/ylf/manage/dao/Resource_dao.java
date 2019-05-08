package com.ylf.manage.dao;

import com.ylf.manage.entity.Resource;
import com.ylf.manage.idao.Resource_idao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Resource_dao extends BaseDao<Resource> implements Resource_idao {
    public int add(Resource resource) {
        return super.add("insertResource",resource);
    }

    public int del(String r_id) {
        return super.del("deleteResourceByPrimaryKey",r_id);
    }

    public List<Resource> findAllCourseResource(String c_id) {
                return super.findLimitAll("selectCourseResource",c_id);
    }
}
