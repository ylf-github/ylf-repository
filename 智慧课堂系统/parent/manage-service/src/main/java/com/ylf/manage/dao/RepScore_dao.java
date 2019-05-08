package com.ylf.manage.dao;

import com.ylf.manage.entity.RepScore;
import com.ylf.manage.idao.RepScore_idao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class RepScore_dao extends BaseDao<RepScore> implements RepScore_idao {
    public int add(RepScore score) {
        return super.add("insertRepScore",score);
    }

    public RepScore getOne(RepScore score) {
        try{
            SqlSession session=super.getSession();
            RepScore repScore=session.selectOne("selectRepScore",score);
            session.commit();
            session.close();
            return repScore;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
