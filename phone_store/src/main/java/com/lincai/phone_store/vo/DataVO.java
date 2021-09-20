package com.lincai.phone_store.vo;

import lombok.Data;

import java.util.List;

/**
 * @author LinCai
 * @create 2021-09-07 10:53
 */
@Data
public class DataVO {
    private List<PhoneCategoryVO> categories;
    private List<PhoneInfoVO> phones;
}
