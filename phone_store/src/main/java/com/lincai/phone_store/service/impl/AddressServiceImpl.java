package com.lincai.phone_store.service.impl;

import com.lincai.phone_store.entity.BuyerAddress;
import com.lincai.phone_store.form.AddressForm;
import com.lincai.phone_store.repository.BuyerAddressRepository;
import com.lincai.phone_store.service.AddressService;
import com.lincai.phone_store.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LinCai
 * @create 2021-09-16 17:03
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private BuyerAddressRepository buyerAddressRepository;

    @Override
    public List<AddressVO> findAll() {

        List<AddressVO> list = buyerAddressRepository.findAll().stream()
                .map(e -> new AddressVO(
                        e.getAddressId(),
                        e.getAreaCode(),
                        e.getBuyerName(),
                        e.getBuyerPhone(),
                        e.getBuyerAddress()
                )).collect(Collectors.toList());

        return list;
    }

    @Override
    public void saveOrUpdate(AddressForm addressForm) {
        BuyerAddress buyerAddress;
        //判断ID是否存在
        if(addressForm.getId() == null){
            buyerAddress = new BuyerAddress();
        } else {
            buyerAddress = buyerAddressRepository.findById(addressForm.getId()).get();
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());
        buyerAddress.setBuyerAddress(stringBuffer.toString());
        buyerAddress.setAreaCode(addressForm.getAreaCode());

        buyerAddressRepository.save(buyerAddress);
    }
}
