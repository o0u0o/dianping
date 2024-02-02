package com.o0u0o.dianping.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.o0u0o.dianping.DianpingApplicationTests;
import com.o0u0o.dianping.model.ShopModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class ShopServiceTest extends DianpingApplicationTests {

    @Autowired
    private ShopService shopService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * v1.0 的搜索
     */
    @Test
    public void search() {
        BigDecimal longitude = new BigDecimal(104.11415835449222);
        BigDecimal latitude = new BigDecimal(30.676322788592337);
        String keyword = "Apple";
        Integer orderby = 1;
        Integer categoryId = 1;
        String tags = "apple";
        List<ShopModel> shopModelList = shopService.search(longitude, latitude, keyword, orderby, categoryId, tags);
        log.info("【搜索结果】={}", gson.toJson(shopModelList));
    }

    public void searchES(){

    }
}