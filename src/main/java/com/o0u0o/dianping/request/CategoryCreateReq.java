package com.o0u0o.dianping.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author aiuiot
 * @Date 2020/3/8 7:58 下午
 * @Descripton: 品类创建请求参数
 **/
@Data
public class CategoryCreateReq {

    @NotBlank(message = "名字不能为空")
    private String name;

    @NotBlank(message = "iconUrl不能为空")
    private String iconUrl;

    @NotNull(message = "权重不能为空")
    private Integer sort;
}
