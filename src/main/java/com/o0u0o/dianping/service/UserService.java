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


    /**
     * 获取用户
     * @param id
     * @return
     * @throws BusinessException
     */
    UserModel getUser(Long id) throws BusinessException;


    /**
     * 注册用户
     * @param registerUser
     * @return
     * @throws BusinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    UserModel register(UserModel registerUser) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * 用户登录
     * @param telephone 手机号
     * @param password 密码
     * @return
     */
    UserModel login(String telephone, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException;


    /**
     * 获取所有用户数量
     * @return
     */
    Integer countAllUser();

}
