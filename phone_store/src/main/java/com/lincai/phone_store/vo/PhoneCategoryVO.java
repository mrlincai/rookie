package com.lincai.phone_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author LinCai
 * @create 2021-09-07 11:23
 * @AllArgsConstructor 带参构造
 */
@Data
@AllArgsConstructor
public class PhoneCategoryVO {

    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
}
