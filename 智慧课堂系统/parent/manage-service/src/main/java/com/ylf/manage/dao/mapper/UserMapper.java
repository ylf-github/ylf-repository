package com.ylf.manage.dao.mapper;

import com.ylf.manage.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String uEmail);

    int insertUser(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uEmail);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}