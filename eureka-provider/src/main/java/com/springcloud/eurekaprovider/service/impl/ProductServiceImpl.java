package com.springcloud.eurekaprovider.service.impl;

import com.springcloud.eurekaprovider.pojo.ProductDTO;
import com.springcloud.eurekaprovider.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description 
 * @author Guoqi
 * @date 2022/03/17 10:49
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<ProductDTO> selectProductList() {
        return Arrays.asList(
                new ProductDTO(1,"HuaWei",3,58880D),
                new ProductDTO(1,"XiaoMi",2,68880D),
                new ProductDTO(1,"Apple",5,78880D)
        );
    }
}
