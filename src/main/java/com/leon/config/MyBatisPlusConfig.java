package com.leon.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * https://www.cnblogs.com/r1-12king/p/14850777.html
 * 新版的 mybatis plus中，OptimisticLockerInterceptor 已经被弃用，改为 OptimisticLockerInterceptor
 */
@Configuration
public class MyBatisPlusConfig {


    /**
     * https://www.cnblogs.com/r1-12king/p/14850777.html
     * 新版的 mybatis plus中，OptimisticLockerInterceptor 已经被弃用，改为 OptimisticLockerInterceptor
     *
     * @return
     */


    /**
     * 旧版本 3.4.0 以后
     *
     * @return
     */
//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//        return new OptimisticLockerInterceptor();
//    }

    /**
     * 新版本
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor()); // 乐观所
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor()); // 分页
        return mybatisPlusInterceptor;
    }
}
