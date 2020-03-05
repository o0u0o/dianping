package com.o0u0o.dianping.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author aiuiot
 */
@Data
public class UserModel implements Serializable {

    private Integer id;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Integer gender;
}