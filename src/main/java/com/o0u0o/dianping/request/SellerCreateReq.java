package com.o0u0o.dianping.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author aiuiot
 * @Date 2020/6/9 12:57 下午
 * @Descripton: 商家创建请求对象
 **/
@Data
public class SellerCreateReq {

    @NotBlank(message = "商户名不能为空")
    private String name;
}
