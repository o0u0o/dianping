package com.o0u0o.dianping.commom;

import lombok.Data;

/**
 * @Author aiuiot
 * @Date 2020/2/27 1:20 上午
 * @Descripton: 通用返回
 **/
@Data
public class R {

    private String status;

    private Object data;

    public static R success(Object result){
        return R.create(result, "success");
    }

    public static R fail(Object result){
        return R.create(result, "fail");
    }

    public static R create(Object result, String status){
        R r = new R();
        r.setStatus(status);
        r.setData(result);

        return r;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
