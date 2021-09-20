package com.lincai.phone_store.exception;

import com.lincai.phone_store.enums.ResultEnum;

/**
 * @author LinCai
 * @create 2021-09-16 14:32
 */
public class PhoneException extends RuntimeException {
    public PhoneException(ResultEnum resultEnums) {
        super(resultEnums.getMsg());
    }

    public PhoneException(String error) {
        super(error);
    }
}
