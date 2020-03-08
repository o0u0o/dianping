package com.o0u0o.dianping.request;

import lombok.Data;

/**
 * @Author aiuiot
 * @Date 2020/3/8 7:55 下午
 * @Descripton: 分页查询
 **/
@Data
public class PageQuery {

    private Integer page = 1;

    private Integer size = 20;
}
