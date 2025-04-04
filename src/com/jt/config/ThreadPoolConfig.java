package com.jt.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jokerjt
 * @version 1.0
 * @date 2025/3/30 19:46
 */

/**
 * 自定义线程池
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor myThreadPool(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,//核心数，一直都能工作的数量
                5,//请求处理大时，可以开放的最大工作数
                3,//开启最大工作数后，当无请求时，还让其存活的时间
                TimeUnit.SECONDS,//存活时间单位
                new LinkedBlockingDeque<>(10),//阻塞队列，保存操作请求线程
                Executors.defaultThreadFactory(),//创建线程的工厂类
                new ThreadPoolExecutor.AbortPolicy());//拒绝策略
        return threadPoolExecutor;
    }


}
