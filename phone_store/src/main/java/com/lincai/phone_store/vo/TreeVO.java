package com.lincai.phone_store.vo;

import lombok.Data;

import java.util.List;

/**
 * @author LinCai
 * @create 2021-09-09 20:58
 * v 为list-> []
 */
@Data
public class TreeVO {
    private String k = "规格";
    private List<PhoneSpecsVO> v;
    private String k_s = "s1";
}
