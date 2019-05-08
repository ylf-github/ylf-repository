package com.ylf.manage.dao.mapper;

import com.ylf.manage.entity.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(String rId);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String rId);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}