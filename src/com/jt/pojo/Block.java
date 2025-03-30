package com.jt.pojo;


import lombok.Builder;
import lombok.Data;

/**
 * @author jokerjt
 * @version 1.0
 * @date 2025/3/30 19:22
 */
@Data
@Builder
public class Block {

    /**
     * 区块高度
     */
    Integer blockNumber;

    /**
     * 区块哈希
     */
    String blockHash;


    /**
     * 区块状态(可能没有)
     */
    String state;

    /**
     * 内容
     */
    String message;

}
