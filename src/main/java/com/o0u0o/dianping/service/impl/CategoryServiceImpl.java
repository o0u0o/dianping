package com.o0u0o.dianping.service.impl;

import com.o0u0o.dianping.commom.enums.BusinessErrorEnum;
import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.dal.CategoryModelMapper;
import com.o0u0o.dianping.model.CategoryModel;
import com.o0u0o.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:13 上午
 * @Descripton: 分类服务实现
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryModelMapper categoryModelMapper;

    /**
     * 创建品类
     * @param categoryModel
     * @return
     * @throws BusinessException
     */
    @Override
    @Transactional
    public CategoryModel create(CategoryModel categoryModel) throws BusinessException {
        categoryModel.setCreatedAt(new Date());
        categoryModel.setUpdatedAt(new Date());
        try{
            categoryModelMapper.insertSelective(categoryModel);
        }catch(DuplicateKeyException ex){
            throw new BusinessException(BusinessErrorEnum.CATEGORY_NAME_DUPLICATED);
        }

        return get(categoryModel.getId());
    }

    /**
     * 根据ID获取品类
     * @param id 品类ID
     * @return
     */
    @Override
    public CategoryModel get(Integer id) {
        return categoryModelMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有分类
     * @return
     */
    @Override
    public List<CategoryModel> selectAll() {
        return categoryModelMapper.selectAll();
    }

    @Override
    public Integer countAllCategory() {
        return categoryModelMapper.countAllCategory();
    }

}
