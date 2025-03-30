package com.jt.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jokerjt
 * @version 1.0
 * @date 2025/3/30 22:24
 */
@Component
public class TaskStart {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private DepositTask depositTask;

    @Autowired
    private WithdrawTask withdrawTask;

    //开始
    @PostConstruct
    public void start(){
        threadPoolExecutor.execute(depositTask);

        threadPoolExecutor.execute(withdrawTask);

    }
}
