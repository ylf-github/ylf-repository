package com.ylf.manage.service;

import com.ylf.manage.entity.RepScore;
import com.ylf.manage.idao.RepScore_idao;
import com.ylf.manage.iservice.RepScore_iserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepScore_serv implements RepScore_iserv {
    @Autowired
    private RepScore_idao dao;
    public int add(RepScore score) {
        return dao.add(score);
    }

    public RepScore getOne(RepScore score) {
        return dao.getOne(score);
    }
}
