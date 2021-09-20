package com.lincai.phone_store.service.impl;

import com.lincai.phone_store.entity.PhoneCategory;
import com.lincai.phone_store.entity.PhoneInfo;
import com.lincai.phone_store.entity.PhoneSpecs;
import com.lincai.phone_store.enums.ResultEnum;
import com.lincai.phone_store.exception.PhoneException;
import com.lincai.phone_store.repository.PhoneCategoryRepository;
import com.lincai.phone_store.repository.PhoneInfoRepository;
import com.lincai.phone_store.repository.PhoneSpecsRepository;
import com.lincai.phone_store.service.PhoneService;
import com.lincai.phone_store.util.PhoneUtil;
import com.lincai.phone_store.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author LinCai
 * @create 2021-09-07 15:00
 */
@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;

    @Autowired
    private PhoneInfoRepository phoneInfoRepository;

    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;

    @Override
    public DataVO findDataVO() {
        //因为要返回一个DataVO对象，所以先创建一个
        DataVO dataVO = new DataVO();

        //类型
        //先查出来实体类
        List<PhoneCategory> phoneCategoryList = phoneCategoryRepository.findAll();

        //从实体类里拿到属性然后遍历赋值到VO(常规写法)
//        List<PhoneCategoryVO> phoneCategoryVOList = new ArrayList<>();
//        for (PhoneCategory phoneCategory : phoneCategoryList) {
//            PhoneCategoryVO phoneCategoryVO = new PhoneCategoryVO();
//            phoneCategoryVO.setCategoryName(phoneCategory.getCategoryName());
//            phoneCategoryVO.setCategoryType(phoneCategory.getCategoryType());
//            phoneCategoryVOList.add(phoneCategoryVO);
//        }
        //stream流写法, .stream-转换成流、.map-筛选、e-每一个phoneCatery、

        List<PhoneCategoryVO> phoneCategoryVOList = phoneCategoryList.stream()
                .map(e -> new PhoneCategoryVO(
                        e.getCategoryName(),
                        e.getCategoryType()
                )).collect(Collectors.toList());
        dataVO.setCategories(phoneCategoryVOList);

        //手机
        //先查出来实体类
        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAllByCategoryType(phoneCategoryList.get(0).getCategoryType());

        //常规写法
//        List<PhoneInfoVO> phoneInfoVOList = new ArrayList<>();
//        for (PhoneInfo phoneInfo : phoneInfoList) {
//            PhoneInfoVO phoneInfoVO = new PhoneInfoVO();
//            //使用工具类，这样就不用一个个去set了
//            BeanUtils.copyProperties(phoneInfo, phoneInfoVO);
//            phoneInfoVO.setTag(PhoneUtil.createTag(phoneInfo.getPhoneTag()));
//            phoneInfoVOList.add(phoneInfoVO);
//        }
        //lambda表达式
        List<PhoneInfoVO> phoneInfoVOList = phoneInfoList.stream()
                .map(e -> new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice(),
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
        dataVO.setPhones(phoneInfoVOList);
        return dataVO;
    }

    @Override
    public List<PhoneInfoVO> findPhoneInfoVOByCategoryType(Integer categoryType) {
        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAllByCategoryType(categoryType);
        List<PhoneInfoVO> phoneInfoVOList = phoneInfoList.stream()
                .map(e -> new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice(),
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
        return phoneInfoVOList;
    }

    @Override
    public SpecsPackageVO findSpecsByPhoneId(Integer phoneId) {

        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneId).get();
        List<PhoneSpecs> phoneSpecsList = phoneSpecsRepository.findAllByPhoneId(phoneId);
        //tree
        List<PhoneSpecsVO> phoneSpecsVOList = new ArrayList<>();
        List<PhoneSpecsCasVO> phoneSpecsCasVOList = new ArrayList<>();
        PhoneSpecsVO phoneSpecsVO;
        PhoneSpecsCasVO phoneSpecsCasVO;
        for (PhoneSpecs phoneSpecs : phoneSpecsList) {
            phoneSpecsVO = new PhoneSpecsVO();
            phoneSpecsCasVO = new PhoneSpecsCasVO();
            BeanUtils.copyProperties(phoneSpecs,phoneSpecsVO);
            BeanUtils.copyProperties(phoneSpecs,phoneSpecsCasVO);
            phoneSpecsVOList.add(phoneSpecsVO);
            phoneSpecsCasVOList.add(phoneSpecsCasVO);
        }
        TreeVO treeVO = new TreeVO();
        treeVO.setV(phoneSpecsVOList);
        List<TreeVO> treeVOList = new ArrayList<>();
        treeVOList.add(treeVO);

        SkuVO skuVO = new SkuVO();
        skuVO.setPrice(phoneInfo.getPhonePrice());
        skuVO.setStock_num(phoneInfo.getPhoneStock());
        skuVO.setTree(treeVOList);
        skuVO.setList(phoneSpecsCasVOList);

        SpecsPackageVO specsPackageVO = new SpecsPackageVO();
        specsPackageVO.setSku(skuVO);
        Map<String,String> goods = new HashMap<>();
        goods.put("picture",phoneInfo.getPhoneIcon());
        specsPackageVO.setGoods(goods);

        return specsPackageVO;
    }

    @Override
    public void subStock(Integer specsId, Integer quantity) {
        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(specsId).get();
        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        Integer result = phoneSpecs.getSpecsStock() - quantity;
        if(result < 0){
            log.error("【扣库存】库存不足");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }
        phoneSpecs.setSpecsStock(result);
        //存入数据库
        phoneSpecsRepository.save(phoneSpecs);

        //总库存也算一次
        result = phoneInfo.getPhoneStock() - quantity;
        if(result < 0){
            log.error("【扣库存】库存不足");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }
        phoneInfo.setPhoneStock(result);
        phoneInfoRepository.save(phoneInfo);
    }
}
