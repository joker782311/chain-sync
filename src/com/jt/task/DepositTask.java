package com.jt.task;


import com.jt.pojo.Transactions;
import com.jt.schedule.SyncScheduleDoge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jokerjt
 * @version 1.0
 * @date 2025/3/30 22:03
 */

/**
 * 处理 扫到的充值，提现，归集交易等
 */
@Component
public class DepositTask implements Runnable{

    @Autowired
    private SyncScheduleDoge syncScheduleDoge;

    @Override
    public void run() {
        while (true){
            Transactions data = null; // 阻塞直到有数据可取
            try {
                data = syncScheduleDoge.normalChannel.take();
                System.out.println(data+"入库");
                //todo 处理数据，入库等
                if(data.getTxType().equals("0")){
                    //充值
                    handleDeposit(data);
                }
                if(data.getTxType().equals("1")){
                    //提现
                    handleWithdraw(data);
                }
                if(data.getTxType().equals("2")){
                    //归集
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    //处理充值
    void handleDeposit(Transactions transactions){
        System.out.println("充值");
    }

    //处理提现
    void handleWithdraw(Transactions transactions){
        System.out.println("提现");
    }
}
