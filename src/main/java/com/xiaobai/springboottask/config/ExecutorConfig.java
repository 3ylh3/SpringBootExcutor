package com.xiaobai.springboottask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置类
 *
 * @author 小白
 * @date 2019/7/9
 */
@Configuration
@EnableAsync
public class ExecutorConfig implements AsyncConfigurer {
    /**
     * 核心线程数
     */
    @Value("${executor.thread.coreSize}")
    private int coreSize;

    /**
     * 最大线程数
     */
    @Value("${executor.thread.maxSize}")
    private int maxSize;

    /**
     * 队列大小
     */
    @Value("${executor.thread.queueCapacity}")
    private int queueCapacity;

    /**
     * 空闲线程保持时间
     */
    @Value("${executor.thread.keepAliveSeconds}")
    private int keepAliveSeconds;

    /**
     * 线程名称前缀
     */
    @Value("${executor.thread.namePrefix}")
    private String prefix;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(coreSize);
        executor.setMaxPoolSize(maxSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix(prefix);
        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
