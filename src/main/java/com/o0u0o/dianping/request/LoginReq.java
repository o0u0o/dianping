package com.o0u0o.dianping.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author aiuiot
 * @Date 2020/2/28 11:07 上午
 * @Descripton: 用户登录表单
 **/
@Data
public class LoginReq {

    @NotBlank(message = "手机号不能为空")
    private String telephone;

    @NotBlank(message = "密码不能为空")
    private String password;
}
