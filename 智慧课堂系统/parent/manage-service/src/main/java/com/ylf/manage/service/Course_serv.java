package com.ylf.manage.service;

import com.ylf.manage.entity.Course;
import com.ylf.manage.entity.Uc_itemKey;
import com.ylf.manage.entity.User;
import com.ylf.manage.idao.Course_idao;
import com.ylf.manage.iservice.Course_iserv;
import com.ylf.manage.iservice.UC_item_iserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Course_serv implements Course_iserv {
    @Autowired
    private Course_idao dao;
    @Autowired
    private UC_item_iserv ucService;

    public int add(Course course,String u_id) {
        Uc_itemKey uc=new Uc_itemKey();
        uc.setcId(course.getcId());
        uc.setuEmail(u_id);
        uc.setcType("1");
        int n=dao.add(course);
        int z=ucService.add(uc);
        return n+z;
    }

    public List<User> findAllJoinUser(String id) {
        return dao.findAllJoin(id);
    }


    public int del(String id) {
        return dao.del(id);
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> by_19/5/8

    public Course getOne(String c_id) {
        return dao.findOne(c_id);
    }
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
}
