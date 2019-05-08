package com.ylf.manage.service;

import com.ylf.manage.entity.Score;
import com.ylf.manage.idao.Score_idao;
import com.ylf.manage.iservice.Score_iserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Score_serv implements Score_iserv {
    @Autowired
    private Score_idao dao;

    public int add(Score score) {
        return dao.add(score);
    }

    public int upd(Score score) {
        return dao.upd(score);
    }

    public List<Score> findCourseScore(String c_id) {
        return dao.findCourseScore(c_id);
    }
}
