package com.o0u0o.dianping.controller;

import com.o0u0o.dianping.commom.R;
import com.o0u0o.dianping.commom.enums.BusinessErrorEnum;
import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.model.CategoryModel;
import com.o0u0o.dianping.model.ShopModel;
import com.o0u0o.dianping.service.CategoryService;
import com.o0u0o.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:09 上午
 * @Descripton: 门店服务
 **/
@Controller("/shop")
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 推荐服务v1.0
     * @param longitude 经度
     * @param latitude 纬度
     * @return
     */
    @RequestMapping("/recommend")
    @ResponseBody
    public R recommend(@RequestParam(name = "longitude")BigDecimal longitude,
                       @RequestParam(name = "latitude") BigDecimal latitude) throws BusinessException {
        //判断经纬度是否为空（lbs必要）
        if (longitude == null || latitude == null){
            throw new BusinessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.recommend(longitude, latitude);
        return R.success(shopModelList);
    }

    /**
     *
     * @param longitude
     * @param latitude
     * @param keyword
     * @param orderby
     * @param category
     * @param tags
     * @return
     * @throws BusinessException
     * @throws IOException
     */
    @RequestMapping("/search")
    @ResponseBody
    public R search(@RequestParam(name = "longitude") BigDecimal longitude,
                    @RequestParam(name = "latitude") BigDecimal latitude,
                    @RequestParam(name = "keyword") String keyword,
                    @RequestParam(name = "orderby", required = false) Integer orderby,
                    @RequestParam(name = "category", required = false) Integer category,
                    @RequestParam(name = "tags", required = false) String tags) throws BusinessException, IOException {
        if (StringUtils.isEmpty(keyword) || longitude == null || latitude == null){
            throw new BusinessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = (List<ShopModel>)shopService.searchES(longitude, latitude, keyword, orderby, category, tags).get("shop");
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        //List<Map<String, Object>> tagsAggregation = shopService.searchGroupByTags(keyword, category, tags);
        HashMap<Object, Object> resMap = new HashMap<>();
        resMap.put("shop", shopModelList);
        resMap.put("category", categoryModelList);
        //resMap.put("tags", tagsAggregation);
        return R.success(resMap);
    }
}
