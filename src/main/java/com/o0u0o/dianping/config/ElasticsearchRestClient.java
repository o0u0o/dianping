package com.o0u0o.dianping.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aiuiot
 * @since  2020/3/13 1:58 下午
 * @deprecated : Elasticsearch相关配置
 **/
@Configuration
public class ElasticsearchRestClient {

    @Value("${elasticsearch.ip}")
    String ipAddress;

    /**
     * 构造highLevelClient 用于其他bean
     * @return RestHighLevelClient
     */
    @Bean(name="highLevelClient")
    public RestHighLevelClient highLevelClient(){
        String[] address = ipAddress.split(":");
        String ip = address[0];
        int port = Integer.valueOf(address[1]);
        HttpHost httpHost = new HttpHost(ip, port,"http");
        return new RestHighLevelClient(RestClient.builder(new HttpHost[]{httpHost}));
    }
}
