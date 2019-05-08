package com.ylf.manage.service;

import com.ylf.manage.entity.Uc_itemKey;
import com.ylf.manage.idao.UC_item_idao;
import com.ylf.manage.iservice.UC_item_iserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UC_item_serv implements UC_item_iserv {
    @Autowired
    private UC_item_idao dao;

    public int add(Uc_itemKey uc) {
        return dao.add(uc);
    }

    public int del(Uc_itemKey uc) {
        return dao.del(uc);
    }

    public List<Uc_itemKey> findAll(String u_id) {
        return dao.findAll(u_id);
    }
}
