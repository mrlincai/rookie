package com.lincai.phone_store.repository;

import com.lincai.phone_store.entity.PhoneCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LinCai
 * @create 2021-09-05 10:42
 */
@SpringBootTest
class PhoneCategoryRepositoryTest {

    @Autowired //自动创建IOC容器然后注入
    private PhoneCategoryRepository repository;

    @Test
    void findAll(){
        List<PhoneCategory> list = repository.findAll();
        for (PhoneCategory phoneCategory : list) {
            System.out.println(phoneCategory);
        }
    }

    @Test
    void findByCategoryType(){
        PhoneCategory phoneCategory = repository.findByCategoryType(1);
        System.out.println(phoneCategory);
    }
}