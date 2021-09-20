package com.lincai.phone_store.service;

import com.lincai.phone_store.form.AddressForm;
import com.lincai.phone_store.vo.AddressVO;

import java.util.List;

/**
 * @author LinCai
 * @create 2021-09-16 18:05
 */
public interface AddressService {
    public List<AddressVO> findAll();
    public void saveOrUpdate(AddressForm addressForm);
}
