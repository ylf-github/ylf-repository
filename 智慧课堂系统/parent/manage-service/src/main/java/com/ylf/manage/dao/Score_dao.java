package com.ylf.manage.dao;

import com.ylf.manage.entity.Score;
import com.ylf.manage.idao.Score_idao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Score_dao extends BaseDao<Score> implements Score_idao {
    public int add(Score score) {
        return super.add("insertScore",score);
    }

    public int upd(Score score) {
        return super.upd("updateScoreByPrimaryKey",score);
    }

    public List<Score> findCourseScore(String c_id) {
        return super.findLimitAll("selectScoreByCid",c_id);
    }
}
