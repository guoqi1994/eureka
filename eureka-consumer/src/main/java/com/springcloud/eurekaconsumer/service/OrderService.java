package com.springcloud.eurekaconsumer.service;

import com.springcloud.eurekaconsumer.pojo.OrderDTO;

import java.util.List;

/**
 * @description 
 * @author Guoqi
 * @date 2022/03/17 10:47
 **/
public interface OrderService {

   OrderDTO selectOrderById(Integer id);
}
