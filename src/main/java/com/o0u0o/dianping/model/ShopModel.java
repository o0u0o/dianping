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

    /** 门店ID */
    private Integer id;

    /** 创建时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;

    /** 商家名 */
    private String name;

    /** 评分 */
    private BigDecimal remarkScore;

    /** 人均消费 */
    private Integer pricePerMan;

    /** 纬度 */
    private BigDecimal latitude;

    /** 经度 */
    private BigDecimal longitude;

    /** 距离 */
    private Integer distance;

    /** 品类ID */
    private Integer categoryId;

    /** 因为是一对多的关系 */
    private CategoryModel categoryModel;

    /** 标签 */
    private String tags;

    /** 门店营业时间 */
    private String startTime;

    /** 门店结束时间 */
    private String endTime;

    /** 门店地址 */
    private String address;

    /** 商家地址 */
    private Integer sellerId;

    /** 商家模型 */
    private SellerModel sellerModel;

    /** 门店URL地址 */
    private String iconUrl;
}
