package com.o0u0o.dianping.service;

import com.o0u0o.dianping.commom.exception.BusinessException;
import com.o0u0o.dianping.model.SellerModel;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/3/6 9:54 上午
 * @Descripton: 商家服务接口
 **/
public interface SellerService {

    /**
     * 创建商家
     * @param sellerModel
     * @return
     */
    SellerModel create(SellerModel sellerModel);

    /**
     * 获取商家
     * @param id
     * @return
     */
    SellerModel get(Integer id);

    /**
     *  获取所有商家
     * @return
     */
    List<SellerModel> selectAll();

    SellerModel changeStatus(Integer id,Integer disabledFlag) throws BusinessException;

    /**
     * 统计所有商家
     * @return
     */
    Integer countAllSeller();


}
