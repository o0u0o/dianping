package com.o0u0o.dianping.service;

import com.o0u0o.dianping.DianpingApplicationTests;
import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class UserServiceTest extends DianpingApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void getUser() throws BusinessException {
        Integer USER_ID = 2;
        UserModel user = userService.getUser(USER_ID);

    }

    @Test
    public void register() throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        UserModel userModel = new UserModel();
        userModel.setTelephone("13009791526");
        userModel.setNickName("小吧子");
        userModel.setPassword("123456");
        userModel.setGender(1);
        UserModel register = userService.register(userModel);
        log.info("【注册了用户】={}", register);
    }

    @Test
    public void login() throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        String telephone = "13009791621";
        String password = "123456";
        UserModel login = userService.login(telephone, password);
        log.info("【登录成功】={}", login);
    }
}