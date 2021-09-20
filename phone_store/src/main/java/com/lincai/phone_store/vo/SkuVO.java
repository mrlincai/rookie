package com.lincai.phone_store.vo;

import lombok.Data;

import java.util.List;

/**
 * @author LinCai
 * @create 2021-09-09 20:34
 * tree 是列表【】
 */
@Data
public class SkuVO {
    private List<TreeVO> tree;
    private List<PhoneSpecsCasVO> list;
    private String price;
    private Integer stock_num;
    private Boolean none_sku = false;
    private Boolean hide_stock = false;
}
