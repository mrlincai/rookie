package com.lincai.phone_store.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author LinCai
 * @create 2021-09-16 17:04
 */
@Data
@AllArgsConstructor
public class AddressVO {
    private Integer id;
    private String areaCode;
    private String name;
    private String tel;
    private String address;
}
