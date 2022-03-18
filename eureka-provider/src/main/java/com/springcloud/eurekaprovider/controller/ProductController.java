package com.springcloud.eurekaprovider.controller;

import com.springcloud.eurekaprovider.pojo.ProductDTO;
import com.springcloud.eurekaprovider.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public List<ProductDTO> selectProductList(){
        return productService.selectProductList();
    }
}
