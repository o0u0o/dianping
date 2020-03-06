package com.o0u0o.dianping.service;

import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.model.CategoryModel;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:11 上午
 * @Descripton: 分类服务接口
 **/
public interface CategoryService {

    CategoryModel create(CategoryModel categoryModel) throws BusinessException;

    CategoryModel get(Integer id);

    List<CategoryModel> selectAll();

    Integer countAllCategory();

}
