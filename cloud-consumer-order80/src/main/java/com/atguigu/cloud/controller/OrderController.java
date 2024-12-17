package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    public static final String PaymentSrv_url = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    /*增*/
    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_url + "/pay/add", payDTO, ResultData.class);
    }

    /*删*/
    public ResultData deleteOrder(@PathVariable("id") Integer id) {
        return restTemplate.postForObject(PaymentSrv_url + "/pay/delete/"+ id, id, ResultData.class);
    }

    /*改*/
    public ResultData updateOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_url + "/pay/update", payDTO, ResultData.class);
    }

    /*查*/
    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_url + "/pay/get/" + id, ResultData.class,id);
    }
}
