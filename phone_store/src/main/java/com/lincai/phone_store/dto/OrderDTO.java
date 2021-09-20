package com.lincai.phone_store.dto;

import lombok.Data;

/**
 * @author LinCai
 * @create 2021-09-16 21:30
 */
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Integer specsId;
    private Integer phoneQuantity;
}
