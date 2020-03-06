package com.o0u0o.dianping.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:22 上午
 * @Descripton: 门店模型
 **/
@Data
public class ShopModel {

    private Integer id;

    /** 创建时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;

    /** 商家名 */
    private String name;

    private BigDecimal remarkScore;

    private Integer pricePerMan;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Integer distance;

    private Integer categoryId;

    private CategoryModel categoryModel;

    private String tags;

    private String startTime;

    private String endTime;

    private String address;

    private Integer sellerId;

    private SellerModel sellerModel;

    private String iconUrl;
}
