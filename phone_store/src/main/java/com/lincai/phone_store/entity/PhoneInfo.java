package com.lincai.phone_store.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LinCai
 * @create 2021-09-05 11:29
 */
@Data
@Entity
public class PhoneInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer phoneId;
    private String phoneName;
    private String phonePrice;
    private String phoneDescription;
    private Integer phoneStock;
    private String phoneIcon;
    private Integer categoryType;
    private String phoneTag;
    private Date createTime;
    private Date updateTime;
}
