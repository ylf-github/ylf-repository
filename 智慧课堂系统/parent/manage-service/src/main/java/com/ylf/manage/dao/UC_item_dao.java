package com.ylf.manage.dao;

import com.ylf.manage.entity.Uc_itemKey;
import com.ylf.manage.idao.UC_item_idao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UC_item_dao extends BaseDao<Uc_itemKey> implements UC_item_idao {
    public int add(Uc_itemKey uc) {
        return super.add("insertUc_item",uc);
    }

    public int del(Uc_itemKey uc) {
        try{
            SqlSession session=super.getSession();
            int n=session.delete("deleteUc_itemByPrimaryKey",uc);
            session.commit();
            session.close();
            return n;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public List<Uc_itemKey> findAll(String u_id) {
        try{
            SqlSession session=super.getSession();
            List<Uc_itemKey> list=session.selectList("selectAllUc_itemByU_id",u_id);
            session.commit();
            session.close();
            return list;
        }catch (Exception e)
        {
            return null;
        }
    }
}
