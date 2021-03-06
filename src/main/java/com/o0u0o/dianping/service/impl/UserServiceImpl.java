package com.o0u0o.dianping.service.impl;

import com.o0u0o.dianping.commom.enums.BusinessErrorEnum;
import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.dal.UserModelMapper;
import com.o0u0o.dianping.model.UserModel;
import com.o0u0o.dianping.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import static com.o0u0o.dianping.commom.utils.encryptPwdUtil.encodeByMd5;

/**
 * @Author aiuiot
 * @Date 2020/2/27 12:13 上午
 * @Descripton: 用户服务实现
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Long id) throws BusinessException {
        UserModel userModel = userModelMapper.selectByPrimaryKey(id);
        if (userModel == null){
            throw new BusinessException(BusinessErrorEnum.USER_DOES_NOT_EXIST);
        }
        //敏感信息脱敏
        userModel.setPassword(null);
        return userModel;
    }

    /**
     * 注册用户
     * 事务的完整性
     * @param registerUser
     * @return
     */
    @Override
    @Transactional
    public UserModel register(UserModel registerUser) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        registerUser.setPassword(encodeByMd5(registerUser.getPassword()));
        registerUser.setCreatedAt(new Date());
        registerUser.setUpdatedAt(new Date());

        try{
            Long i = userModelMapper.insertSelective(registerUser);
            //捕获唯一键冲突
        }catch (DuplicateKeyException exception){
            throw new BusinessException(BusinessErrorEnum.REGISTER_DUP_FAIL);
        }

        return getUser(registerUser.getId());
    }

    /**
     * 用户登录
     * @param telphone 手机号
     * @param password 密码
     * @return
     */
    @Override
    public UserModel login(String telphone, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException {
        UserModel userModel = userModelMapper.selectByTelephoneAndPassword(telphone, encodeByMd5(password));
        if (userModel == null){
            throw new BusinessException(BusinessErrorEnum.LOGIN_FAIL);
        }
        return userModel;
    }

    /**
     * 获取所有用户
     * @return
     */
    @Override
    public Integer countAllUser() {
        return userModelMapper.countAllUser();
    }


}
