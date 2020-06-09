package com.o0u0o.dianping.dal;

import com.o0u0o.dianping.model.SellerModel;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:58 上午
 * @Descripton: 商家Mapper
 **/
public interface SellerModelMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(SellerModel record);

    List<SellerModel> selectAll();

    int insertSelective(SellerModel record);

    SellerModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellerModel record);

    int updateByPrimaryKey(SellerModel record);

    /**
     * 统计商家数
     * @return
     */
    Integer countAllSeller();
}
