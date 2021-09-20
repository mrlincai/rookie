package com.lincai.phone_store.entity;

import com.sun.javafx.geom.transform.Identity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author LinCai
 * @create 2021-09-04 16:33
 */
@Data /**自动生成setter、getter方法*/
@Entity  /**@Entity定义对象将会成为被JPA管理的实体，将映射到指定的数据库表*/
public class PhoneCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;


}
