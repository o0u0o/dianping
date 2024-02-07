package com.o0u0o.dianping.dal;

import com.o0u0o.dianping.model.CategoryModel;

import java.util.List;

public interface CategoryModelMapper {

    /**
     * <h2>根据主键ID删除</h2>
     * @param id 主键ID
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * <h2>获取所有</h2>
     * @return
     */
    List<CategoryModel> selectAll();

    Integer countAllCategory();

    int insert(CategoryModel record);

    int insertSelective(CategoryModel record);

    CategoryModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryModel record);

    int updateByPrimaryKey(CategoryModel record);
}