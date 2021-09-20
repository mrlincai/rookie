package com.lincai.phone_store.repository;

import com.lincai.phone_store.entity.PhoneCategory;
import com.lincai.phone_store.entity.PhoneInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LinCai
 * @create 2021-09-05 14:53
 */
@SpringBootTest
class PhoneInfoRepositoryTest {
    @Autowired
    private PhoneInfoRepository repository;

    @Test
    void findAll(){
        List<PhoneInfo> list = repository.findAll();
        for (PhoneInfo phoneInfo : list) {
            System.out.println(phoneInfo);
        }
    }

    @Test
    void findAllByCategoryType(){
        List<PhoneInfo> list = repository.findAllByCategoryType(1);
        for (PhoneInfo phoneInfo : list) {
            System.out.println(phoneInfo);
        }
    }
}