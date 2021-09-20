package com.lincai.phone_store.util;

import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LinCai
 * @create 2021-09-07 17:04
 * createTag方法 将为 String 类型的字符串分割并且返回成 List<Map<String,String>> 类型
 */
public class PhoneUtil {
    public static List<Map<String, String>> createTag(String tag) {
        String[] tars = tag.split("&");
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        for (String s : tars) {
            map = new HashMap<>();
            map.put("name", s);
            list.add(map);
        }
        return list;
    }
}
