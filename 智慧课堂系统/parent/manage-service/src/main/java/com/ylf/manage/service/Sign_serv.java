package com.ylf.manage.service;

import com.ylf.manage.entity.Sign;
import com.ylf.manage.entity.Signer;
import com.ylf.manage.entity.User;
import com.ylf.manage.idao.Sign_idao;
import com.ylf.manage.idao.User_idao;
import com.ylf.manage.iservice.Course_iserv;
import com.ylf.manage.iservice.Signer_iserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class Sign_serv implements com.ylf.manage.iservice.Sign_iserv {
    @Autowired
    private Sign_idao dao;
    @Autowired
    private Course_iserv cService;
    @Autowired
    private Signer_iserv signerService;
    @Autowired
    private User_idao udao;

    public int add(Sign sign) {
        int n=dao.add(sign);
        List<User> users=cService.findAllJoinUser(sign.getcId());
<<<<<<< HEAD
<<<<<<< HEAD
        for(int i=0;i<users.size();i++){
            Signer signer=new Signer();
            signer.setcId(sign.getcId());
            signer.setsId(sign.getsId());
            signer.setCreateTime(sign.getTime());
            signer.setsTime("未签到");
            signer.setsType("0");     //默认0为未签到
            signer.setuEmail(users.get(i).getuEmail());
            signerService.add(signer);
=======
=======
>>>>>>> by_19/5/8
        if(users!=null){
            for(int i=0;i<users.size();i++){
                Signer signer=new Signer();
                signer.setcId(sign.getcId());
                signer.setsId(sign.getsId());
                signer.setCreateTime(sign.getTime());
                signer.setsTime("未签到");
                signer.setsType("0");     //默认0为未签到
                signer.setuEmail(users.get(i).getuEmail());
                signerService.add(signer);
            }
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
        }
        return n;
    }

    public int del(String s_id) {
        return dao.del(s_id);
    }

    public Sign getOne(String s_id) {
        return dao.getOne(s_id);
    }

    public List<User> findAllIsSigner(String s_id) {
        return udao.getIsSignUser(s_id);
    }

    public List<User> findAllNotSigner(String s_id) {
        return udao.getNotSignUser(s_id);
    }

    public List<Sign> getCourseSignInfo(String c_id) {
        return dao.getCourseSign(c_id);
    }
}
