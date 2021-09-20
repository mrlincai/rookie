package com.lincai.phone_store.controller;

import com.lincai.phone_store.service.PhoneService;
import com.lincai.phone_store.util.ResultVOUtil;
import com.lincai.phone_store.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LinCai
 * @create 2021-09-17 17:06
 */
@CrossOrigin
@RestController
@RequestMapping("/phone")
public class PhoneHander {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/index")
    public ResultVO index() {
        return ResultVOUtil.success(phoneService.findDataVO());
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVO findByCategoryType(
            @PathVariable("categoryType") Integer categoryType) {
        return ResultVOUtil.success(phoneService.findPhoneInfoVOByCategoryType(categoryType));
    }

    @GetMapping("/findSpecsByPhoneId/{phoneId}")
    public ResultVO findSpecsByPhoneId(
            @PathVariable("phoneId") Integer phoneId) {
        return ResultVOUtil.success(phoneService.findSpecsByPhoneId(phoneId));
    }
}
