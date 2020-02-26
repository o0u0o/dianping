package com.o0u0o.dianping.commom.exception;

import com.o0u0o.dianping.commom.CommonError;
import com.o0u0o.dianping.commom.enums.BusinessErrorEnum;
import lombok.Data;
import lombok.Getter;

/**
 * @Author aiuiot
 * @Date 2020/2/27 1:42 上午
 * @Descripton: 通用异常处理
 **/
@Data
public class BusinessException extends Exception{

    private CommonError commonError;

    public BusinessException(BusinessErrorEnum businessErrorEnum){
        super();
        this.commonError = new CommonError(businessErrorEnum);
    }

}
