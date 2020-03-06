package com.o0u0o.dianping.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:40 上午
 * @Descripton: 分类模型
 **/
@Data
public class CategoryModel {

    private Integer id;


    private Date createdAt;


    private Date updatedAt;


    private String name;


    private String iconUrl;


    private Integer sort;
}
