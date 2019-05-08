package com.ylf.manage.service;

import com.ylf.manage.entity.Course;
import com.ylf.manage.entity.Uc_itemKey;
import com.ylf.manage.entity.Uemail;
import com.ylf.manage.entity.User;
import com.ylf.manage.idao.Course_idao;
import com.ylf.manage.idao.UC_item_idao;
import com.ylf.manage.idao.User_idao;
import com.ylf.manage.iservice.User_iserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class User_serv implements User_iserv {
    @Autowired
    private User_idao dao;
    @Autowired
    private UC_item_idao ucDao;
    @Autowired
    private Course_idao cdao;

    public int add(User user) {
        return dao.add(user);
    }

    public int upd(User user) {
        return dao.upd(user);
    }

    public int del(String id) {
        return dao.del(id);
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public User findOne(String id) {
        return dao.findOne(id);
    }

    public List<Course> findAllJoinCourse(String id) {
        User user=dao.findOne(id);
        List<Course> courses=user.getCourses();
        List<Uc_itemKey> ucs=ucDao.findAll(id);
        List<Course> result=new ArrayList<Course>();
        for(int i=0;i<courses.size();i++){
            for(int j=0;j<ucs.size();j++){
                if(courses.get(i).getcId().equals(ucs.get(j).getcId())&&ucs.get(j).getcType().equals("2")){
                   result.add(courses.get(i));
                }
            }
        }
        return result;
    }

    public List<Course> findAllCreateCourse(String id) {
        User user=dao.findOne(id);
        List<Course> courses=user.getCourses();
        List<Uc_itemKey> ucs=ucDao.findAll(id);
        List<Course> result=new ArrayList<Course>();
        for(int i=0;i<courses.size();i++){
            for(int j=0;j<ucs.size();j++){
                if(courses.get(i).getcId().equals(ucs.get(j).getcId())&&ucs.get(j).getcType().equals("1")){
                    result.add(courses.get(i));
                }
            }
        }
        return result;
    }

    public int joinCourse(String u_id, String c_id) {
        Course course=cdao.findOne(c_id);
        if(course==null){ //班课不存在
            return 0;
        }
        Uc_itemKey uc=new Uc_itemKey();
        uc.setcId(c_id);
        uc.setuEmail(u_id);
        uc.setcType("2");
        int z=ucDao.add(uc);
        return z;
    }

    public int updId(Uemail uemail) {
        return dao.updId(uemail);
    }

    public int updPass(User user) {
        return dao.updPass(user);
    }
}
