package com.lincai.phone_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author LinCai
 * @create 2021-09-09 21:26
 */
@Data
public class PhoneSpecsCasVO {
    @JsonProperty("s1")
    private Integer specsId;
    @JsonProperty("price")
    private BigDecimal specsPrice;
    @JsonProperty("stock_num")
    private Integer specsStock;
}
