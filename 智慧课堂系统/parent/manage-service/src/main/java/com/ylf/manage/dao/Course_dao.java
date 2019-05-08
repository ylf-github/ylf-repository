package com.ylf.manage.dao;

import com.ylf.manage.entity.Course;
import com.ylf.manage.entity.User;
import com.ylf.manage.idao.Course_idao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class Course_dao extends BaseDao<Course> implements Course_idao {
    public int add(Course course) {
        return super.add("insertCourse",course);
    }

    public Course findOne(String id) {
        return super.getOne("selectCourseByPrimaryKey",id);
    }


    public int del(String id) {
        return super.del("deleteCourseByPrimaryKey",id);
    }

    public List<User> findAllJoin(String c_id) {
       try{
           SqlSession session=super.getSession();
           List<User> list=session.selectList("com.ylf.manage.dao.mapper.UserMapper.selectUserByCid",c_id);
           session.commit();
           session.close();
           return  list;
       }catch (Exception e){
           e.printStackTrace();
           return  null;
       }
    }

}
