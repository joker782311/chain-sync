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

    String TxType;

    String Version;

    String Status;

    Long Timestamp;
}
