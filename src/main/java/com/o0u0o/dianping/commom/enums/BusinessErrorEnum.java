package com.o0u0o.dianping.commom.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Author aiuiot
 * @Date 2020/2/27 1:31 上午
 * @Descripton: 业务错误枚举
 **/
@Getter
public enum BusinessErrorEnum {

    /**
     * 通用错误类型 10000开头
     */
    NO_OBJECT_FOUND(10001, "请求对象不存在"),

    UNKNOWN_ERROR(10002, "未知错误"),

    NO_HANDLER_FOUND(10003, "找不到执行的路径操作"),

    BIND_EXCEPTION_ERROR(10004, "请求参数错误")

    ;

    private Integer errCode;

    private String errMsg;

    BusinessErrorEnum(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
