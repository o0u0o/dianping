package com.o0u0o.dianping.service;

import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.model.ShopModel;
import com.o0u0o.dianping.model.vo.ShopListVO;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author  aiuiot
 * @since  2020/3/6 9:11 上午
 * @Descripton: 门店服务接口
 **/
public interface ShopService {

    /**
     * <h2>创建门店</h2>
     * @param shopModel
     * @return ShopModel
     */
    ShopModel create(ShopModel shopModel) throws BusinessException;

    /**
     * <h2>获取门店</h2>
     * @param id 门店ID
     * @return ShopModel
     */
    ShopModel get(Integer id);

    /**
     * <h2>获取所有门店</h2>
     * @return
     */
    List<ShopModel> selectAll();

    /**
     * <h2>推荐附近门店v1.0</h2>
     * @param longitude 经度
     * @param latitude  纬度
     * @return
     */
    List<ShopListVO> recommend(BigDecimal longitude, BigDecimal latitude);

    /**
     * <h2>统计门店</h2>
     * @return
     */
    Integer countAllShop();

    /**
     * <h2>根据标签分组进行搜索v1.0</h2>
     * @param keyword      关键字
     * @param categoryId   品类ID
     * @param tags         标签
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> searchGroupByTags(String keyword, Integer categoryId, String tags);

    /**
     * <h2>搜索门店v1.0</h2>
     * @param longitude     经度
     * @param latitude      纬度
     * @param keyword       搜索关键词
     * @param orderby       排序
     * @param categoryId    品类ID
     * @param tags          标签
     * @return
     */
    List<ShopModel> search(BigDecimal longitude,
                           BigDecimal latitude,
                           String keyword,
                           Integer orderby,
                           Integer categoryId,
                           String tags);

    /**
     * 搜索门店2.0
     * @param longitude
     * @param latitude
     * @param keyword
     * @param orderby
     * @param categoryId
     * @param tags
     * @return
     */
    Map<String, Object> searchES(BigDecimal longitude,
                                 BigDecimal latitude,
                                 String keyword,
                                 Integer orderby,
                                 Integer categoryId,
                                 String tags) throws IOException;
}
