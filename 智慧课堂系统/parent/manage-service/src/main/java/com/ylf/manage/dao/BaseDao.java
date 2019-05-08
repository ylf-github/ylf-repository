package com.ylf.manage.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseDao <T>{

    public BaseDao(){

    }

    @Autowired
    protected SqlSessionFactoryBean sqlSessionFactoryBean;

    protected SqlSession getSession() throws Exception{
        return sqlSessionFactoryBean.getObject().openSession();   //返回sqlSession
    }

    protected int add(String command,T obj){       //添加一个实体
        try{
           SqlSession session=getSession();
           int n=session.insert(command,obj);
           session.commit();
           session.close();
           return n;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    protected T getOne(String command,String id){          //查找一个实体
         try{
             SqlSession session=getSession();
             T t=session.selectOne(command,id);
             session.commit();
             session.close();
             return t;
         }catch (Exception e){
             return null;
         }
    }

    protected List<T> findAll(String command){           //查找所有
          try{
              SqlSession session=getSession();
              List<T> list=session.selectList(command);
              session.commit();
              session.close();
              return  list;
          }catch (Exception e){
              return null;
          }
    }

    protected int del(String command, String id){      //删除一个对象
        try{
            SqlSession session=getSession();
            int n=session.delete(command,id);
            session.commit();
            session.close();
            return n;
        }catch (Exception e){
            return 0;
        }
    }

    protected int upd(String command,T t){       //更新一个对象
        try{
            SqlSession session=getSession();
            int n=session.update(command,t);
            session.commit();
            session.close();
            return n;
        }catch (Exception e){
            return 0;
        }
    }

    protected List<T> findLimitAll(String command,String arg){   //限定查找所有
        try{
            SqlSession session=getSession();
            List<T> list=session.selectList(command,arg);
            session.commit();
            session.close();
            return  list;
        }catch (Exception e){
            return null;
        }
    }

}
