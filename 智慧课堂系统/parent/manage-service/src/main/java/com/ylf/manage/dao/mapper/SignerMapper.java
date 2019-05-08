package com.ylf.manage.dao.mapper;

import com.ylf.manage.entity.Signer;

public interface SignerMapper {
    int insert(Signer record);

    int insertSelective(Signer record);
}