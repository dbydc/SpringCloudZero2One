package com.dbydc.zero2one.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Feign认证请求拦截器
 * @author 大白有点菜
 * @className FeignAuthRequestInterceptor
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
public class FeignAuthRequestInterceptor implements RequestInterceptor {

    private String tokenId;

    public FeignAuthRequestInterceptor(String tokenId) {
        this.tokenId = tokenId;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", tokenId);
    }
}
