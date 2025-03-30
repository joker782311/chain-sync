package com.jt.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestReturn {

    private Integer code=1; //成功返回1

    private String message;

    private Object data;

    public static RestReturn success(String message, Object data){
        return new RestReturn(1,message,data);
    }
    public static RestReturn success(Object data){
       return new RestReturn(1,"成功",data);
    }
    public static RestReturn success(){
        return new RestReturn(1,"成功",null);
    }

    public static RestReturn fail(String message){
        return new RestReturn(-1,message,null);
    }
}
