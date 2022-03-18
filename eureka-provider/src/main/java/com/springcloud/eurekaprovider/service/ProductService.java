package com.springcloud.eurekaprovider.service;

import com.springcloud.eurekaprovider.pojo.ProductDTO;

import java.util.List;

/**
 * @description 
 * @author Guoqi
 * @date 2022/03/17 10:47
 **/
public interface ProductService {

    List<ProductDTO> selectProductList();
}
