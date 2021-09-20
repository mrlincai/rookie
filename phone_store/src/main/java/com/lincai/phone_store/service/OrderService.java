package com.lincai.phone_store.service;

import com.lincai.phone_store.dto.OrderDTO;
import com.lincai.phone_store.vo.OrderDetailVO;

/**
 * @author LinCai
 * @create 2021-09-16 20:51
 */
public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);
    public OrderDetailVO findOrderDetailByOrderId(String orderId);
    public String pay(String orderId);
}
