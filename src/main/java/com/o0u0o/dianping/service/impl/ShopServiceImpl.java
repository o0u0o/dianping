package com.o0u0o.dianping.service.impl;

import com.o0u0o.dianping.commom.enums.BusinessErrorEnum;
import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.dal.ShopModelMapper;
import com.o0u0o.dianping.model.CategoryModel;
import com.o0u0o.dianping.model.SellerModel;
import com.o0u0o.dianping.model.ShopModel;
import com.o0u0o.dianping.service.CategoryService;
import com.o0u0o.dianping.service.SellerService;
import com.o0u0o.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:12 上午
 * @Descripton: 门店服务实现
 **/
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopModelMapper shopModelMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SellerService sellerService;

    /**
     * 创建门店
     * @param shopModel 门店模型
     * @return
     */
    @Override
    @Transactional
    public ShopModel create(ShopModel shopModel) throws BusinessException {
        shopModel.setCreatedAt(new Date());
        shopModel.setUpdatedAt(new Date());

        //校验商家是否存在正确
        SellerModel sellerModel = sellerService.get(shopModel.getSellerId());
        if (sellerModel == null){
            throw new BusinessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR, "商户不存在");
        }

        if (sellerModel.getDisabledFlag().intValue() == 1){
            throw new BusinessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR, "商户被禁用");
        }

        //校验类目
        CategoryModel categoryModel = categoryService.get(shopModel.getCategoryId());
        if (categoryModel == null){
            throw new BusinessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR, "类目不存在");
        }

        shopModelMapper.insert(shopModel);
        return get(shopModel.getId());
    }

    /**
     * 根据门店ID获取门店
     * @param id 门店ID
     * @return
     */
    @Override
    public ShopModel get(Integer id) {
        ShopModel shopModel = shopModelMapper.selectByPrimaryKey(id);
        if (shopModel == null){
            return null;
        }
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
