package com.jt.pojo;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jokerjt
 * @version 1.0
 * @date 2025/3/30 20:18
 */
@Data
@Builder
public class Transactions {

    String BlockHash;

    Long BlockNumber;

    String Hash;

    String FromAddress;

    String ToAddress;

    String Amount;

    BigDecimal Fee;

    String LockTime;

    String TxType; //0充值,1提现,2归集,3转冷

    String Version;

    String Status;

    Long Timestamp;
}
