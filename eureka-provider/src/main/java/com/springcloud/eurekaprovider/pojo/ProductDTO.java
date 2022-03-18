package com.springcloud.eurekaprovider.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description 
 * @author Guoqi
 * @date 2022/03/17 10:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private Integer id;
    private String productName;
    private Integer productNum;
    private Double productPrice;
}
