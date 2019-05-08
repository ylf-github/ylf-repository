package com.ylf.manage.idao;

import com.ylf.manage.entity.Uc_itemKey;

import java.util.List;

public interface UC_item_idao {
      int add(Uc_itemKey uc);  //添加对应关系---创课
      int del(Uc_itemKey uc);  //删除对应关系---退课
      List<Uc_itemKey> findAll(String u_id); //查找与特定用户有关的对应关系

}
