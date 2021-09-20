package com.lincai.phone_store.enums;

import lombok.Getter;

/**
 * @author LinCai
 * @create 2021-09-17 10:45
 */
@Getter
public enum PayStatusEnum {
    UNPAID(0,"未支付"),
    PAID(1,"已支付");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
