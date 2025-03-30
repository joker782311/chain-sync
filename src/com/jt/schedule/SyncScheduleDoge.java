package com.jt.schedule;

import com.jt.config.ThreadPoolConfig;
import com.jt.pojo.Block;
import com.jt.pojo.Transactions;
import com.jt.service.BlockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jt
 * @date 2025/3/30 17:22
 */


@Slf4j
@Component
public class SyncScheduleDoge {

    public LinkedBlockingQueue<Transactions> normalChannel = new LinkedBlockingQueue<>(10000); //充值,提现,归集，转冷


    public LinkedBlockingQueue<Transactions> fallbackChannel = new LinkedBlockingQueue<>(10000); //回滚

    private AtomicLong lastBlockNumber = new AtomicLong(0L);

    @Autowired
    private BlockService blockService;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    //模拟狗狗币扫链逻辑
    @Scheduled(fixedRate = 10000)
    public void executeTask() {
        System.out.println("Task executed at: " + System.currentTimeMillis());
        //获取最新区块
        Long lastBlockNumber1 = blockService.getLastBlockNumber(lastBlockNumber.get());
        if(lastBlockNumber1>lastBlockNumber.get()){
            int height = (int) (lastBlockNumber1 - lastBlockNumber.get());
            Future<List<Transactions>>[] futures = new Future[height];
            for (int i = 0; i < height; i++) {
                int taskId = i;
                futures[i] = threadPoolExecutor.submit(() -> {
                    // 模拟任务执行
                    List<Transactions> transactions = List.of();
                    try {
                        //模拟获取block里的交易列表
                        transactions = parseTransaction(lastBlockNumber.get()+ taskId +1);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                    return transactions;
                });
            }

            for (int i = 0; i < height; i++) {
                try {
                    futures[i].get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            this.lastBlockNumber.set(lastBlockNumber1);
            
        }
    }


    /**
     * 模拟解析交易
     * @param number
     * @return
     */
    public List<Transactions> parseTransaction(Long number){

        List<Transactions> blockTxInfoLists = blockService.getBlockTxInfo(number);
        blockTxInfoLists.forEach(res->{
            putChannel(normalChannel,res);
        });
        return blockTxInfoLists;

    }

    private void putChannel(LinkedBlockingQueue channel,Transactions transactions){
        try {
            channel.put(transactions);
            System.out.println("正在处理"+transactions);
        }
        catch (InterruptedException e){
            log.info("未记录", transactions);
            throw new RuntimeException(e);
        }
    }




}
