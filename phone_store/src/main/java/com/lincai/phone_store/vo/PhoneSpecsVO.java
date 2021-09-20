package com.lincai.phone_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author LinCai
 * @create 2021-09-09 21:17
 * 与数据库数据直接相关的命名得看看数据库的属性名称，例如：PhoneSpecsVO的命名
 */
@Data
public class PhoneSpecsVO {
    @JsonProperty("id")
    private Integer specsId;
    @JsonProperty("name")
    private String specsName;
    @JsonProperty("imgUrl")
    private String specsIcon;
    @JsonProperty("previewImgUrl")
    private String specsPreview;
}
