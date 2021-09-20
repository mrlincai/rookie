package com.lincai.phone_store.service.impl;

import com.lincai.phone_store.form.AddressForm;
import com.lincai.phone_store.service.AddressService;
import com.lincai.phone_store.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LinCai
 * @create 2021-09-16 18:51
 */
@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    void findAll() {
        List<AddressVO> list = addressService.findAll();
        int id = 0;
    }

    @Test
    void saveOrUpdate(){
        AddressForm addressForm = new AddressForm();
        addressForm.setId(2);
        addressForm.setName("李四");
        addressForm.setTel("13612344321");
        addressForm.setProvince("北京市");
        addressForm.setCity("北京市");
        addressForm.setCounty("东城区");
        addressForm.setAreaCode("110101");
        addressForm.setAddressDetail("168号606室");
        addressService.saveOrUpdate(addressForm);
    }
}