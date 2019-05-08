package com.ylf.manage.iservice;

import com.ylf.manage.entity.Score;

import java.util.List;

public interface Score_iserv {
    int add(Score score); //初始化经验值
    int upd(Score score); //更新经验值
    List<Score> findCourseScore(String c_id); //查询某课程所有经验值对象
}
