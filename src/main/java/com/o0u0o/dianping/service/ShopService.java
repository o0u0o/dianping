package com.o0u0o.dianping.service;

import com.o0u0o.dianping.model.ShopModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:11 上午
 * @Descripton: 门店服务接口
 **/
public interface ShopService {

    /**
     * 创建门店
     * @param shopModel
     * @return
     */
    ShopModel create(ShopModel shopModel);

    /**
     * 获取门店
     * @param id 门店ID
     * @return
     */
    ShopModel get(Integer id);

    /**
     * 获取所有门店
     * @return
     */
    List<ShopModel> selectAll();

    /**
     * 推荐附近门店
     * @param longitude 经度
     * @param latitude  纬度
     * @return
     */
    List<ShopModel> recommend(BigDecimal longitude, BigDecimal latitude);

    /**
     * 统计门店
     * @return
     */
    Integer countAllShop();

    /**
     * 搜索门店
     * @param longitude 经度
     * @param latitude 纬度
     * @param keyword 关键词
     * @param orderby 排序
     * @param categoryId 分类ID
     * @param tags 标签
     * @return
     */
    List<ShopModel> search(BigDecimal longitude,
                           BigDecimal latitude,
                           String keyword,
                           Integer orderby,
                           Integer categoryId,
                           String tags);
}
