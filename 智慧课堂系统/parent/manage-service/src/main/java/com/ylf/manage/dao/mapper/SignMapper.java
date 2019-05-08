package com.ylf.manage.dao.mapper;

import com.ylf.manage.entity.Sign;

public interface SignMapper {
    int deleteByPrimaryKey(String sId);

    int insert(Sign record);

    int insertSelective(Sign record);

    Sign selectByPrimaryKey(String sId);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);
}