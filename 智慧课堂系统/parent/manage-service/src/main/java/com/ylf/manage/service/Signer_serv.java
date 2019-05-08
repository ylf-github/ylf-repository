package com.ylf.manage.service;

import com.ylf.manage.entity.Signer;
import com.ylf.manage.idao.Signer_idao;
import com.ylf.manage.iservice.Signer_iserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Signer_serv implements Signer_iserv {
    @Autowired
    private Signer_idao dao;

    public int add(Signer signer) {
        return dao.add(signer);
    }

    public int upd(Signer signer) {
        return dao.upd(signer);
    }

    public List<Signer> signInfo(Signer signer) {
        return dao.signInfo(signer);
    }
}
