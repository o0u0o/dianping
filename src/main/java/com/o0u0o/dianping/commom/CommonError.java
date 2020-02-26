package com.o0u0o.dianping.commom;

import com.o0u0o.dianping.commom.enums.BusinessErrorEnum;
import lombok.Data;

/**
 * @Author aiuiot
 * @Date 2020/2/27 1:29 上午
 * @Descripton: 通用错误码
 **/
@Data
public class CommonError {

    /**
     * 错误码
     */
    private Integer errCode;

    /**
     * 错误描述
     */
    private String errMsg;

    public CommonError(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public CommonError(BusinessErrorEnum businessErrorEnum){
        this.errCode = businessErrorEnum.getErrCode();
        this.errMsg = businessErrorEnum.getErrMsg();
    }
}
