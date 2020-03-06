package com.o0u0o.dianping.controller;

import com.o0u0o.dianping.commom.R;
import com.o0u0o.dianping.commom.enums.BusinessErrorEnum;
import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.model.ShopModel;
import com.o0u0o.dianping.service.CategoryService;
import com.o0u0o.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:09 上午
 * @Descripton: 门店服务
 **/
//@RestController
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
    public R recommend(@RequestParam(name = "longitude")BigDecimal longitude,
                       @RequestParam(name = "latitude") BigDecimal latitude) throws BusinessException {
        //判断经纬度是否为空（lbs必要）
        if (longitude == null || latitude == null){
            throw new BusinessException(BusinessErrorEnum.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.recommend(longitude, latitude);
        return R.create(shopModelList, "成功");
    }
}
