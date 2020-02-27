package com.o0u0o.dianping.commom.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @Author aiuiot
 * @Date 2020/2/28 12:22 上午
 * @Descripton: 公共工具
 **/
public class CommonUtil {

    public static String processErrorString(BindingResult bindingResult){
        if (!bindingResult.hasErrors()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            stringBuilder.append(fieldError.getDefaultMessage() + ',');
        }
        //删除最后一个逗号的拼接
        stringBuilder.substring(0, stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
