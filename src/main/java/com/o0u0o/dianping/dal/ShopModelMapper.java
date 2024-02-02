package com.o0u0o.dianping.dal;

import com.o0u0o.dianping.model.ShopModel;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:33 上午
 * @Descripton: 门店Mapper
 **/
public interface ShopModelMapper {

    int deleteByPrimaryKey(Integer id);

    Integer countAllShop();

    int insert(ShopModel record);

    int insertSelective(ShopModel record);

    ShopModel selectByPrimaryKey(Integer id);

    List<ShopModel> selectAll();

    int updateByPrimaryKeySelective(ShopModel record);

    int updateByPrimaryKey(ShopModel record);

    /**
     * <h2>推荐v1.0</h2>
     * @param longitude 经度
     * @param latitude  纬度
     * @return List<ShopModel> 附近的门店（95%由距离因子）
     */
    List<ShopModel> recommend(@Param("longitude") BigDecimal longitude,
                              @Param("latitude") BigDecimal latitude);

    /**
     * 根据标签分组进行搜索v1.0
     * @param keyword       搜索关键字
     * @param categoryId    服务类目ID
     * @param tags          标签
     * @return
     */
    List<Map<String, Object>> searchGroupByTags(@Param("keyword") String keyword,
                                                @Param("categoryId") Integer categoryId,
                                                @Param("tags") String tags);

    /**
     * 搜索门店v1.0
     * @param longitude     经度
     * @param latitude      纬度
     * @param keyword       关键字
     * @param orderby       排序
     * @param categoryId    服务品类ID
     * @param tags          标签
     * @return
     */
    List<ShopModel> search(@Param("longitude") BigDecimal longitude,
                           @Param("latitude") BigDecimal latitude,
                           @Param("keyword") String keyword,
                           @Param("orderby") Integer orderby,
                           @Param("categoryId") Integer categoryId,
                           @Param("tags") String tags);

}
