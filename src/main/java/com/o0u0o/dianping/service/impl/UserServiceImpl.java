package com.o0u0o.dianping.service.impl;

import com.o0u0o.dianping.dal.UserModelMapper;
import com.o0u0o.dianping.model.UserModel;
import com.o0u0o.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author aiuiot
 * @Date 2020/2/27 12:13 上午
 * @Descripton: 用户服务实现
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {

        return userModelMapper.selectByPrimaryKey(id);
    }
}
