package com.dbydc.zero2one.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * 添加监听 ApplicationReadyEvent 的组件来记录加载的属性源
 * @author 大白有点菜
 * @className LoadedConfigFileListener
 * @date 2023-04-06
 * @description
 * @since 1.0
 **/
@Component
@Slf4j
public class LoadedConfigFileListener implements ApplicationListener<ApplicationReadyEvent>, Ordered {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        MutablePropertySources propertySources = event.getApplicationContext().getEnvironment().getPropertySources();
        Iterator<PropertySource<?>> propertySourceIterator = propertySources.iterator();
        propertySourceIterator.forEachRemaining(propertySource -> log.error("Successfully loaded: \"{}\" into application context", propertySource.getName()));
    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
    }
}