package com.o0u0o.dianping.service;

import com.o0u0o.dianping.model.UserModel;
import org.springframework.stereotype.Service;

/**
 * @Author aiuiot
 * @Date 2020/2/27 12:12 上午
 * @Descripton: 用户服务接口
 **/
public interface UserService {

    UserModel getUser(Integer id);

}
