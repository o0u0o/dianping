package com.o0u0o.dianping.service;

import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.model.UserModel;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author aiuiot
 * @Date 2020/2/27 12:12 上午
 * @Descripton: 用户服务接口
 **/
public interface UserService {

    UserModel getUser(Integer id);

    /**
     * 注册用户
     * @param registerUser
     * @return
     */
    UserModel register(UserModel registerUser) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;

}
