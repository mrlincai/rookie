package com.lincai.phone_store.repository;

import com.lincai.phone_store.entity.PhoneCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LinCai
 * @create 2021-09-05 10:17
 */
public interface PhoneCategoryRepository extends JpaRepository<PhoneCategory,Integer> {
    public PhoneCategory findByCategoryType(Integer categoryType);

}
