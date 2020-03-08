package com.o0u0o.dianping.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:41 上午
 * @Descripton: 卖家
 **/
@Data
public class SellerModel {

    /** 商家ID */
    private Integer id;

    /** 商家名 */
    private String name;

    /** 创建时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;

    /** 评分 */
    private BigDecimal remarkScore;

    /** 是否被禁用 1-被禁用 */
    private Integer disabledFlag;
}
