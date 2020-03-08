package com.o0u0o.dianping.commom.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author aiuiot
 * @Date 2020/3/8 6:41 下午
 * @Descripton: 加密密码
 **/
public class encryptPwdUtil {

    /**
     * 加密密码
     * @param password 传入的密码
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encodeByMd5(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确认计算方法为MD5
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(messageDigest.digest(password.getBytes("utf-8")));

    }
}
