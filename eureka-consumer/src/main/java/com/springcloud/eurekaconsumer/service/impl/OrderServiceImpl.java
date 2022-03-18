package com.springcloud.eurekaconsumer.service.impl;

import com.springcloud.eurekaconsumer.pojo.OrderDTO;
import com.springcloud.eurekaconsumer.pojo.ProductDTO;
import com.springcloud.eurekaconsumer.service.OrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description 
 * @author Guoqi
 * @date 2022/03/17 10:49
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Override
    public OrderDTO selectOrderById(Integer id) {
        return new OrderDTO(id,"order01","北京",38888D,
                selectProductByBalanceAnnotation());
    }

    //第一种使用DiscoveryClient
    private List<ProductDTO> selectProductByLoadBalancerClient(){
        StringBuffer sb = null;

        ServiceInstance si = loadBalancerClient.choose("service-provider");
        if(null == si){
            return null;
        }

        sb=new StringBuffer();
        sb.append("http://"+si.getHost()+":"+si.getPort()+"/product/list");


        ResponseEntity<List<ProductDTO>> responseEntity=restTemplate.exchange(
                //服务的实例名eureka-product
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDTO>>(){}
        );
        return responseEntity.getBody();
    }


    //第二种使用LoadBalancerClient
    private List<ProductDTO> selectProductByDiscoveryClient(){
        StringBuffer sb = null;

        List<String> services = discoveryClient.getServices();
        if(CollectionUtils.isEmpty(services)){
            return null;
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        if(CollectionUtils.isEmpty(instances)){
            return null;
        }

        ServiceInstance serviceInstance = instances.get(0);
        sb=new StringBuffer();
        sb.append("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/list");


        ResponseEntity<List<ProductDTO>> responseEntity=restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDTO>>(){}
        );
        return responseEntity.getBody();
    }


    //第三种使用BalanceAnnotation
    private List<ProductDTO> selectProductByBalanceAnnotation(){
        ResponseEntity<List<ProductDTO>> responseEntity=restTemplate.exchange(
                //服务的实例名service-provide
                "http://service-provider/product/list",
               HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDTO>>(){}
        );
        return responseEntity.getBody();
    }
}
