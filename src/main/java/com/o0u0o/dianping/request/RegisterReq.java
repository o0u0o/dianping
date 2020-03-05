package com.o0u0o.dianping.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author aiuiot
 * @Date 2020/2/28 12:05 上午
 * @Descripton: 前端传入的参数
 **/
@Data
public class RegisterReq {

    @NotBlank(message = "手机号不能为空")
    private String telephone;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    @NotNull(message = "性别不能为空")
    private Integer gender;
}
