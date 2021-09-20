package com.lincai.phone_store.util;

import com.lincai.phone_store.vo.ResultVO;

/**
 * @author LinCai
 * @create 2021-09-17 17:08
 */
public class ResultVOUtil {
    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(String error){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg(error);
        resultVO.setData(null);
        return resultVO;
    }
}
