package com.jt.schedule;

import com.jt.config.ThreadPoolConfig;
import com.jt.pojo.Block;
import com.jt.pojo.Transactions;
import com.jt.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jt
 * @date 2025/3/30 17:22
 */


@Component
public class SyncScheduleDoge {

    private Long lastBlockNumber= 0L;

    @Autowired
    private BlockService blockService;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    //模拟狗狗币扫链逻辑
    @Scheduled(fixedRate = 10000)
    public void executeTask() {
        System.out.println("Task executed at: " + System.currentTimeMillis());
        //获取最新区块
        Long lastBlockNumber1 = blockService.getLastBlockNumber(lastBlockNumber);
        if(lastBlockNumber1>lastBlockNumber){
            int height = (int) (lastBlockNumber1 - lastBlockNumber);
            Future<List<Transactions>>[] futures = new Future[height];
            for (int i = 0; i < height; i++) {
                int taskId = i;
                futures[i] = threadPoolExecutor.submit(() -> {
                    // 模拟任务执行
                    List<Transactions> transactions = List.of();
                    try {
                        transactions = parseTransaction(lastBlockNumber+ taskId +1);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                    return transactions;
                });
            }

            for (int i = 0; i < height; i++) {
                try {
                    futures[i].get();
//                    System.out.println("Task " + i + " result: " + futures[i].get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }


            this.lastBlockNumber=lastBlockNumber1;
            
        }
    }


    /**
     * 模拟解析交易
     * @param number
     * @return
     */
    public List<Transactions> parseTransaction(Long number){

        List<Transactions> blockTxInfoLists = blockService.getBlockTxInfo(number);
        return blockTxInfoLists;

    }




}
