package com.o0u0o.dianping.service;

import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.model.CategoryModel;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:11 上午
 * @Descripton: 分/品类服务接口
 **/
public interface CategoryService {

    /**
     * 创建品类
     * @param categoryModel
     * @return
     * @throws BusinessException
     */
    CategoryModel create(CategoryModel categoryModel) throws BusinessException;

    /**
     * 根据品类ID获取品类
     * @param id
     * @return
     */
    CategoryModel get(Integer id);

    /**
     * 获取所有品类
     * @return
     */
    List<CategoryModel> selectAll();

    /**
     *
     * @return
     */
    Integer countAllCategory();

}
