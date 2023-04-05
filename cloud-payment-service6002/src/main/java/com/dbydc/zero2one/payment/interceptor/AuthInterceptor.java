package com.dbydc.zero2one.payment.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证请求拦截器
 * @author 大白有点菜
 * @className AuthInterceptor
 * @date 2023-04-03
 * @description
 * @since 1.0
 **/
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //逻辑认证
        String authorization = request.getHeader("Authorization");
        log.error("获取的认证信息 Authorization：{}", authorization);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json;charset=UTF-8");
        if (StringUtils.hasText(authorization) && authorization.equals("666")) {
            return true;
        }
        return false;
    }
}
