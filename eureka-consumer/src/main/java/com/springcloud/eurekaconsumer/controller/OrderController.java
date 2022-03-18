package com.springcloud.eurekaconsumer.controller;

import com.springcloud.eurekaconsumer.pojo.OrderDTO;
import com.springcloud.eurekaconsumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description 
 * @author Guoqi
 * @date 2022/03/17 10:46
 **/

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService ;

    @RequestMapping("/getOrder")
    public OrderDTO selectProductList(){
        return orderService.selectOrderById(1);
    }
}
