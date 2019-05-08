package com.ylf.manage.dao.mapper;

import com.ylf.manage.entity.Score;

public interface ScoreMapper {

    int insert(Score record);

    int insertSelective(Score record);

    int updateByPrimaryKeySelective(Score record);

}