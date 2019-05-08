package com.ylf.manage.dao.mapper;

import com.ylf.manage.entity.RepScore;

public interface RepScoreMapper {
    int insert(RepScore record);

    int insertSelective(RepScore record);
}