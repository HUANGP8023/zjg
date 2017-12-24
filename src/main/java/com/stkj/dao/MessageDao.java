package com.stkj.dao;

import com.stkj.model.Messgae;

public interface MessageDao {
    int deleteByPrimaryKey(Long mid);

    int insert(Messgae record);

    int insertSelective(Messgae record);

    Messgae selectByPrimaryKey(Long mid);

    int updateByPrimaryKeySelective(Messgae record);

    int updateByPrimaryKey(Messgae record);
}