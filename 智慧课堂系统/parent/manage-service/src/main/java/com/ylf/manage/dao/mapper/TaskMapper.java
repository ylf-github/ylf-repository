package com.ylf.manage.dao.mapper;

import com.ylf.manage.entity.Task;

public interface TaskMapper {
    int deleteByPrimaryKey(String tId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String tId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}