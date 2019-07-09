package com.xiaobai.springboottask.controller;

import com.xiaobai.springboottask.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 执行任务controller
 *
 * @author 小白
 * @date 2019/7/9
 */
@RestController
public class ExecuteTaskController {
    @Autowired
    private ExecutorService executorService;

    @RequestMapping("/execute")
    public void execute(){
        executorService.executeTask();
    }
}
