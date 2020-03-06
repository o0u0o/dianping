package com.o0u0o.dianping.dal;

import com.o0u0o.dianping.model.CategoryModel;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 10:07 上午
 * @Descripton: 分类模型映射
 **/
public interface CategoryModelMapper {

    int deleteByPrimaryKey(Integer id);

    List<CategoryModel> selectAll();

    Integer countAllCategory();


    int insert(CategoryModel record);


    int insertSelective(CategoryModel record);


    CategoryModel selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(CategoryModel record);


    int updateByPrimaryKey(CategoryModel record);
}
