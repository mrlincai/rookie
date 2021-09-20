package com.lincai.phone_store.vo;

import lombok.Data;

/**
 * @author LinCai
 * @create 2021-09-17 18:01
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
