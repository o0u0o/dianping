package com.o0u0o.dianping.dal;

import com.o0u0o.dianping.model.UserModel;

public interface UserModelMapper {

    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(Integer id);
}