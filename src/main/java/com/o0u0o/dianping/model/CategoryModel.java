package com.o0u0o.dianping.model;

import lombok.Data;

import java.util.Date;

/**
 * @author aiuiot
 */
@Data
public class CategoryModel {

    /** 品类ID */
    private Integer id;

    /** 创建时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;

    /** 品类名 */
    private String name;

    /** 图标url */
    private String iconUrl;

    /** 排序 */
    private Integer sort;
}