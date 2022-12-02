package com.pyy.pharmacy.order.controller;


import com.pyy.pharmacy.order.entity.PyyOrder;
import com.pyy.pharmacy.order.service.IOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private  RestTemplate restTemplate;
    @Autowired
    private IOrderService orderService;


    @ApiOperation("订单添加")
    @PostMapping("/add")
    public  void add(@RequestBody PyyOrder pyyOrder){
        orderService.add(pyyOrder);

       /* 通过注册中心方便url的改变*/
       /* String forObject = restTemplate.getForObject("http://stock-service:8011/stock/qu", String.class);
        return "add"+forObject;*/
    }
    @ApiOperation("订单查询")
    @GetMapping("/selectAll")
    public List<PyyOrder> selectAll(){
        return orderService.selectAll();
    }
}
