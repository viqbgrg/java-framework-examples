package com.github.viqbgrg.swaggerdemo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


/**
 * @ClassName Result
 * @Description API 返回实体类
 * @Author LiangYao
 * @Date 2020/09/17 14:01
 * @Version 1.0
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T>{

    private Integer code;
    private String msg;
    private T data;


    public Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }




}
