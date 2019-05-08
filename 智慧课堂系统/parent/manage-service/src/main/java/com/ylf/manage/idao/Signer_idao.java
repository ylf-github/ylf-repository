package com.ylf.manage.idao;

import com.ylf.manage.entity.Signer;

import java.util.List;

public interface Signer_idao {
    int add(Signer signer);  //添加签到信息
    int upd(Signer signer);  //更新签到信息
    List<Signer> signInfo(Signer signer); //返回某用户某课程的全部签到信息
}
