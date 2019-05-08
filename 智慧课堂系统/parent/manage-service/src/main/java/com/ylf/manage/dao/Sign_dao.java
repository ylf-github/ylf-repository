package com.ylf.manage.dao;

import com.ylf.manage.entity.Sign;
import com.ylf.manage.idao.Sign_idao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class Sign_dao extends BaseDao<Sign> implements Sign_idao {
    public int add(Sign sign) {
        return super.add("insertSign",sign);
    }

    public int del(String s_id) {
        return super.del("deleteSignByPrimaryKey",s_id);
    }

    public Sign getOne(String s_id) {
        return super.getOne("selectSignByPrimaryKey",s_id);
    }

    public List<Sign> getCourseSign(String c_id) {
        try{
            SqlSession session=super.getSession();
            List<Sign> list=session.selectList("selectCourseSign",c_id);
            session.commit();
            session.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
