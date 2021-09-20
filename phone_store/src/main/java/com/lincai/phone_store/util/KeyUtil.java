package com.lincai.phone_store.util;

import java.util.Random;

/**
 * @author LinCai
 * @create 2021-09-17 10:21
 */
public class KeyUtil {
    public static synchronized String createUniqueKey(){
        Random random = new Random();
        Integer key = random.nextInt(900000)+100000;
        return System.currentTimeMillis() + String.valueOf(key);
    }
}
