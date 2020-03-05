package com.o0u0o.dianping.commom.exception;

import com.o0u0o.dianping.commom.CommonError;
import com.o0u0o.dianping.commom.R;
import com.o0u0o.dianping.commom.enums.BusinessErrorEnum;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author aiuiot
 * @Date 2020/2/27 1:48 上午
 * @Descripton: 全局异常助手 - 统一处理异常
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R doError(HttpServletRequest request, HttpServletResponse response, Exception exception){
        if (exception instanceof BusinessException){
            return R.fail(((BusinessException)exception).getCommonError());
        }

        if (exception instanceof NoHandlerFoundException){
            //404 异常处理
            CommonError commonError = new CommonError(BusinessErrorEnum.NO_HANDLER_FOUND);
            return R.fail(commonError);
        }

        // 请求参数错误
        if (exception instanceof ServletRequestBindingException){
            CommonError commonError = new CommonError(BusinessErrorEnum.BIND_EXCEPTION_ERROR);
            return R.fail(commonError);
        }



        else {
            //其他的为 未知错误 防止入侵
            CommonError commonError = new CommonError(BusinessErrorEnum.UNKNOWN_ERROR);
            return R.fail(commonError);
        }
    }
}
