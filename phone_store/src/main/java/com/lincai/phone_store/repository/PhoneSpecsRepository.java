package com.lincai.phone_store.repository;

import com.lincai.phone_store.entity.PhoneSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author LinCai
 * @create 2021-09-05 11:44
 */
public interface PhoneSpecsRepository extends JpaRepository<PhoneSpecs,Integer> {
    public List<PhoneSpecs> findAllByPhoneId(Integer phoneId);
}
