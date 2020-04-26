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

    BIND_EXCEPTION_ERROR(10004, "请求参数错误"),

    PARAMETER_VALIDATION_ERROR(10005, "请求参数校验失败"),

    /**
     * 用户服务相关的错误类型
     */
    REGISTER_DUP_FAIL(20001, "用户已存在"),

    LOGIN_FAIL(20002, "手机号或密码错误"),




    USER_DOES_NOT_EXIST(20003, "用户不存在"),

    /**
     * admin 相关错误
     */
    ADMIN_SHOULD_LOGIN(30001, "管理员需要先登录"),

    /**
     * 品类相关错误
     */
    CATEGORY_NAME_DUPLICATED(40001, "品类名已存在")
    ;

    private Integer errCode;

    private String errMsg;

    BusinessErrorEnum(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
