package com.lincai.phone_store.service;

import com.lincai.phone_store.vo.DataVO;
import com.lincai.phone_store.vo.PhoneInfoVO;
import com.lincai.phone_store.vo.SpecsPackageVO;

import java.util.List;

/**
 * @author LinCai
 * @create 2021-09-07 10:33
 * 查询手机规格findSpecsByPhoneId
 */
public interface PhoneService {
    public DataVO findDataVO();
    public List<PhoneInfoVO> findPhoneInfoVOByCategoryType(Integer categoryType);
    public SpecsPackageVO findSpecsByPhoneId(Integer phoneId);
    public void subStock(Integer specsId,Integer quantity);



}
