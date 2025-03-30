package com.jt.service;


import com.jt.pojo.Block;
import com.jt.pojo.Transactions;
import com.jt.util.UuidUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jokerjt
 * @version 1.0
 * @date 2025/3/30 19:21
 */

@Service
public class BlockService {

    //模拟rpc获取最新区块号
    public Long getLastBlockNumber(Long number){
        int randomNum = (int) (Math.random() * 10);
        return (long)randomNum+number;
    }

    //模拟rpc获取最新区块
    public List<Block> getLastBlock(Integer number){
        List<Block> blockList = new ArrayList<>();
        int randomNum = (int) (Math.random() * 10);
        for (int i = 0; i < randomNum; i++) {
            blockList.add(Block.builder()
                    .blockHash(UuidUtils.randomUUID())
                    .blockNumber(number+i+1)
                    .state("")
                    .message(UuidUtils.randomUUID())
                    .build());
        }
        return blockList;
    }

    //模拟获取区块交易列表
    public List<Transactions> getBlockTxInfo(Long number){
        List<Transactions> transactionsList =new ArrayList<>();
        int randomNum = (int) (Math.random() * 10);
        int txType = (int) (Math.random() * 4);
        for (int i = 0; i < randomNum; i++) {
            transactionsList.add(Transactions.builder()
                    .BlockHash(UuidUtils.randomUUID())
                    .BlockNumber((long) (number+i+1))
                    .FromAddress("")
                    .ToAddress("")
                    .TxType(String.valueOf(txType)) //随机给个类型
                    .build());
        }
        return transactionsList;
    }
}
