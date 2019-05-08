package com.ylf.manage.dao;

import com.ylf.manage.entity.Signer;
import com.ylf.manage.idao.Signer_idao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Signer_dao extends BaseDao<Signer> implements Signer_idao {
    public int add(Signer signer) {
        return super.add("insertSigner",signer);
    }

    public int upd(Signer signer) {
        try{
            SqlSession session=super.getSession();
            int n=session.update("updateSingerType",signer);
            session.commit();
            session.close();
            return  n;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public List<Signer> signInfo(Signer signer) {
        try{
            SqlSession session=super.getSession();
            List<Signer> list=session.selectList("selectCourseSinger",signer);
            session.commit();
            session.close();
            return  list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
