package com.xiaobai.springboottask.service.impl;

import com.xiaobai.springboottask.service.ExecutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 线程任务实现类
 *
 * @author 小白
 * @date 2019/7/9
 */
@Service
public class ExecutorServiceImpl implements ExecutorService {
    private Logger logger = LoggerFactory.getLogger(ExecutorServiceImpl.class);

    @Override
    @Async
    public void executeTask() {
        logger.info("do task...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            logger.info(e.toString());
        }
        logger.info("finish");
    }
}
