package com.lincai.phone_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author LinCai
 * @create 2021-09-07 11:28
 * @AllArgsConstructor 带参构造
 */
@Data
@AllArgsConstructor
public class PhoneInfoVO {
    @JsonProperty("id")
    private Integer phoneId;
    @JsonProperty("title")
    private String phoneName;
    @JsonProperty("price")
    private String phonePrice;
    @JsonProperty("desc")
    private String phoneDescription;
    private List<Map<String, String>> tag;
    @JsonProperty("thumb")
    private String phoneIcon;
}
