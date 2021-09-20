package com.lincai.phone_store.repository;

import com.lincai.phone_store.entity.PhoneInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author LinCai
 * @create 2021-09-05 11:44
 * 
 */

public interface PhoneInfoRepository extends JpaRepository<PhoneInfo,Integer> {
    public List<PhoneInfo> findAllByCategoryType(Integer CategoryType);
}
