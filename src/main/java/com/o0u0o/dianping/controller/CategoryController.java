package com.o0u0o.dianping.controller;

import com.o0u0o.dianping.commom.R;
import com.o0u0o.dianping.model.CategoryModel;
import com.o0u0o.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/6/9 1:16 下午
 * @Descripton: 品类接口
 **/
@Controller("/category")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 所有品类
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public R list(){
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        return R.create(categoryModelList);
    }
}
