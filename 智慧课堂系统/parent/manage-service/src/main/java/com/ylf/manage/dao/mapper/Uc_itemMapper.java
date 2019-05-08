package com.ylf.manage.dao.mapper;

import com.ylf.manage.entity.Uc_itemKey;

public interface Uc_itemMapper {
    int deleteByPrimaryKey(Uc_itemKey key);

    int insert(Uc_itemKey record);

    int insertSelective(Uc_itemKey record);

    Uc_itemKey selectByPrimaryKey(Uc_itemKey key);

    int updateByPrimaryKeySelective(Uc_itemKey record);

    int updateByPrimaryKey(Uc_itemKey record);
}