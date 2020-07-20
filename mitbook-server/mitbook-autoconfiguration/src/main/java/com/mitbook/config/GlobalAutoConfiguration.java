package com.mitbook.config;

import com.mitbook.core.GlobalTransactionManager;
import com.mitbook.support.aspect.GlobalConnectionAspect;
import com.mitbook.support.aspect.GlobalTransactionalAspect;
import com.mitbook.support.holder.TransactionalProperties;
import com.mitbook.support.marker.GlobalServerMarkerConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分布式事务配置类
 *
 * @author pengzhengfa
 */
@Configuration
@Slf4j
@EnableConfigurationProperties(TransactionalProperties.class)
@ConditionalOnBean(GlobalServerMarkerConfiguration.class)
public class GlobalAutoConfiguration {
    
    @Bean
    public GlobalConnectionAspect globalConnectionAspect() {
        log.info("加载GlobalConnectionAspect切面到容器中");
        return new GlobalConnectionAspect();
    }
    
    @Bean
    public GlobalTransactionalAspect globalTransactionalAspect() {
        log.info("加载GlobalTransactionalAspect切面到容器中");
        return new GlobalTransactionalAspect();
    }
    
    @Bean
    public GlobalTransactionManager globalTransactionManager() {
        log.info("加载GlobalTransactionManager到容器中");
        return new GlobalTransactionManager();
    }
}