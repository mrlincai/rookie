package com.lincai.phone_store.vo;

import lombok.Data;

import java.util.Map;

/**
 * @author LinCai
 * @create 2021-09-09 20:25
 */
@Data
public class SpecsPackageVO {
    private Map<String,String> goods;
    private SkuVO sku;
}
