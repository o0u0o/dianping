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
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:12 上午
 * @Descripton: 门店服务实现
 **/
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private RestHighLevelClient highLevelClient;

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

        shopModelMapper.insertSelective(shopModel);
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
        shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
        shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        return shopModel;
    }

    /**
     * 获取所有门店
     * @return
     */
    @Override
    public List<ShopModel> selectAll() {
        List<ShopModel> shopModelList = shopModelMapper.selectAll();
        shopModelList.forEach(shopModel -> {
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        });
        return shopModelList;
    }

    /**
     * 推荐门店
     * @param longitude 经度
     * @param latitude  纬度
     * @return
     */
    @Override
    public List<ShopModel> recommend(BigDecimal longitude, BigDecimal latitude) {
        List<ShopModel> shopModelList =  shopModelMapper.recommend(longitude, latitude);
        //聚合卖家个分类
        shopModelList.forEach(shopModel -> {
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        });
        return shopModelList;
    }

    /**
     * 统计门店
     * @return
     */
    @Override
    public Integer countAllShop() {
        return shopModelMapper.countAllShop();
    }

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

    /**
     * 搜索门店 v2.0
     * @param longitude 经度
     * @param latitude  纬度
     * @param keyword   关键词
     * @param orderby
     * @param categoryId
     * @param tags
     * @return
     */
    @Override
    public Map<String, Object> searchES(BigDecimal longitude, BigDecimal latitude, String keyword, Integer orderby, Integer categoryId, String tags) throws IOException {
        Map<String, Object> result = new HashMap<>();

        // 构建MatchQuery 查询方式
        SearchRequest searchRequest = new SearchRequest("shop");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("name", keyword));
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);

        List<Integer> shopIdsList = new ArrayList<>();
        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            shopIdsList.add(new Integer(hit.getSourceAsMap().get("id").toString()));
        }

        List<ShopModel> shopModelList = shopIdsList.stream().map(id -> {
            return get(id);
        }).collect(Collectors.toList());

        result.put("shop", shopModelList);
        return result;
    }
}
