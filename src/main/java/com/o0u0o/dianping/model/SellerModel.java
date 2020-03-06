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

    private Integer id;


    private String name;


    private Date createdAt;


    private Date updatedAt;


    private BigDecimal remarkScore;

    private Integer disabledFlag;
}
