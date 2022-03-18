package com.springcloud.eurekaconsumer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description 
 * @author Guoqi
 * @date 2022/03/17 11:08
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Integer id;

    private String orderNo;

    private String orderAddress;

    private Double totalPrice;

    private List<ProductDTO> productDTOList;
}
