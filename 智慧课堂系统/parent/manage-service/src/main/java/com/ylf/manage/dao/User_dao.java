package com.ylf.manage.dao;

import com.ylf.manage.entity.Uemail;
import com.ylf.manage.entity.User;
import com.ylf.manage.idao.User_idao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class User_dao extends BaseDao<User> implements User_idao {

    public int add(User user) {
        return super.add("insertUser",user);
    }

    public int upd(User user) {
        return super.upd("updateUserByPrimaryKey",user);
    }

    public int del(String id) {
        return super.del("deleteUserByPrimaryKey",id);
    }

    public List<User> findAll() {
        return super.findAll("selectUserList");
    }

    public User findOne(String id) {
        return super.getOne("selectUserByPrimaryKey",id);
    }

    public int updId(Uemail uemail) {
        try{
            SqlSession session=super.getSession();
            int n=session.update("updateUserId",uemail);
            session.commit();
            session.close();
            return n;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public List<User> getIsSignUser(String s_id) {
        try{
            SqlSession session=super.getSession();
            List<User> list=session.selectList("selectUserBySidTrue",s_id);
            session.commit();
            session.close();
            return  list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getNotSignUser(String s_id) {
        try{
            SqlSession session=super.getSession();
            List<User> list=session.selectList("selectUserBySidFalse",s_id);
            session.commit();
            session.close();
            return  list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int updPass(User user) {
        return super.upd("updateUserByPrimaryKeySelective",user);
    }
}
