package com.o0u0o.dianping.controller;

import com.o0u0o.dianping.service.CategoryService;
import com.o0u0o.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
