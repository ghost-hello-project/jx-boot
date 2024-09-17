package com.laolang.jx.framework.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.laolang.jx.framework.mybatis.interceptor.MybatisPrintSqlInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis plus 配置类.
 *
 * @author laolang
 * @version 0.1
 */
@Configuration
@MapperScan("com.laolang.jx.**.mapper")
public class JxMyBatisAutoConfiguration {

    /**
     * 打印 sql 拦截器.
     * todo dev 环境开启.
     *
     * @return Interceptor
     */
    @Bean
    public Interceptor mybatisPrintSqlInterceptor() {
        return new MybatisPrintSqlInterceptor();
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }
}
