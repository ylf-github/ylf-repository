package com.ylf.manage.iservice;

import com.ylf.manage.entity.Uc_itemKey;

import java.util.List;

public interface UC_item_iserv {
     int add(Uc_itemKey uc);    //添加对应关系
     int del(Uc_itemKey uc);    //删除对应关系
     List<Uc_itemKey> findAll(String u_id);//
}
