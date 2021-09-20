package com.lincai.phone_store.service.impl;

import com.lincai.phone_store.dto.OrderDTO;
import com.lincai.phone_store.service.OrderService;
import com.lincai.phone_store.vo.OrderDetailVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LinCai
 * @create 2021-09-17 10:56
 */
@SpringBootTest
@Service
class OrderServerImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("13678787878");
        orderDTO.setBuyerAddress("广东省深圳市罗湖区科技路123号456室");
        orderDTO.setSpecsId(1);
        orderDTO.setPhoneQuantity(1);

        OrderDTO result = orderService.create(orderDTO);
        System.out.println(result);
    }

    @Test
    void findDetail(){
        OrderDetailVO orderDetailVO = orderService.findOrderDetailByOrderId("1631847691424992593");
        int id = 10;
    }

    @Test
    void pay(){
        System.out.println(orderService.pay("1631847691424992593"));
    }

}