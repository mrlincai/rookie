package com.lincai.phone_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author LinCai
 * @create 2021-09-17 11:09
 */
@Data
public class OrderDetailVO {
    private String orderId;
    private String buyerName;
    @JsonProperty("tel")
    private String buyerPhone;
    @JsonProperty("address")
    private String buyerAddress;
    @JsonProperty("num")
    private Integer phoneQuantity;
    private String phoneName;
    @JsonProperty("specs")
    private String specsName;
    @JsonProperty("price")
    private String specsPrice;
    @JsonProperty("icon")
    private String phoneIcon;
    @JsonProperty("amount")
    private BigDecimal orderAmount;
    private Integer payStatus;
    private Integer freight = 10;
}
