package com.jt.task;


import org.springframework.stereotype.Component;

/**
 * @author jokerjt
 * @version 1.0
 * @date 2025/3/30 22:32
 */
@Component
public class WithdrawTask implements Runnable{

    @Override
    public void run() {

        while (true){
            //查询数据库,提现表

            //查询已经签名但是未提交的交易 UnSendWithdrawsList

            //将交易提交到区块链

            //更新交易状态,以提交到区块 ..扫链模块扫到会更新到以上链

        }
    }
}
