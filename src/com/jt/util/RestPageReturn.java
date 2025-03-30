package com.jt.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author com.jt
 * @date 2024/8/3 18:24
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestPageReturn {

    private Integer code=1; //成功返回1

    private String message;

    //页号
    private Integer current;

    //每页数量
    private Integer pagesize;

    //总数
    private Integer totals;

    private Object data;


    public static RestPageReturn success(Object data, Integer totals, Integer current, Integer pageSize){
        RestPageReturn pageReturn = new RestPageReturn();
        pageReturn.setCode(1);
        pageReturn.setCurrent(current);
        pageReturn.setPagesize(pageSize);
        pageReturn.setData(data);
        pageReturn.setMessage("成功");
        pageReturn.setTotals(totals);
        return pageReturn;
    }


    public static RestPageReturn fail(String message){
        RestPageReturn pageReturn = new RestPageReturn();
        pageReturn.setCode(-1);
        pageReturn.setMessage(message);
        return pageReturn;

    }
}
