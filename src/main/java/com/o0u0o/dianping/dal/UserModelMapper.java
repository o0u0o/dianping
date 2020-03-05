package com.o0u0o.dianping.dal;

import com.o0u0o.dianping.model.UserModel;
import org.apache.ibatis.annotations.Param;

/**
 * UserModelMapper
 * @author aiuiot
 */
public interface UserModelMapper {

    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(Integer id);

    /**
     * 使用手机号和密码查询
     * @param telephone 手机号
     * @param password 密码
     * @return
     */
    UserModel selectByTelephoneAndPassword(@Param("telephone") String telephone, @Param("password") String password);
}