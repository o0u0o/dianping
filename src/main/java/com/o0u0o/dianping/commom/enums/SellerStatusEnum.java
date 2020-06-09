package com.o0u0o.dianping.commom.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Author aiuiot
 * @Date 2020/6/9 1:07 下午
 * @Descripton: 商户状态枚举
 **/
@Getter
public enum  SellerStatusEnum {


    UP(0, "未禁用"),

    DOWN(1, "禁用")
    ;

    private Integer code;

    private String msg;

    SellerStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
