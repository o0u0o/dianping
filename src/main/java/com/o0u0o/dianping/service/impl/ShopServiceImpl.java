package com.o0u0o.dianping.service.impl;

import com.o0u0o.dianping.dal.ShopModelMapper;
import com.o0u0o.dianping.model.ShopModel;
import com.o0u0o.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:12 上午
 * @Descripton: 门店服务实现
 **/
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopModelMapper shopModelMapper;

    @Override
    public ShopModel create(ShopModel shopModel) {
        return null;
    }

    @Override
    public ShopModel get(Integer id) {
        return null;
    }

    /**
     * 获取所有门店
     * @return
     */
    @Override
    public List<ShopModel> selectAll() {
        List<ShopModel> shopModelList = shopModelMapper.selectAll();
        shopModelList.forEach(shopModel -> {
            //shopModel
        });
        return null;
    }

    /**
     * 推荐门店
     * @param longitude 经度
     * @param latitude  纬度
     * @return
     */
    @Override
    public List<ShopModel> recommend(BigDecimal longitude, BigDecimal latitude) {
        return null;
    }

    @Override
    public Integer countAllShop() {
        return null;
    }

    /**
     * 搜索闷蛋
     * @param longitude 经度
     * @param latitude 纬度
     * @param keyword 关键词
     * @param orderby 排序
     * @param categoryId 分类ID
     * @param tags 标签
     * @return
     */
    @Override
    public List<ShopModel> search(BigDecimal longitude, BigDecimal latitude,
                                  String keyword, Integer orderby,
                                  Integer categoryId, String tags) {
//        List<ShopModel> shopModelList = shopModelMapper.search(longitude,latitude,keyword,orderby,categoryId,tags);
//        shopModelList.forEach(shopModel -> {
//            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
//            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
//        });
//        return shopModelList;
        return null;
    }
}
