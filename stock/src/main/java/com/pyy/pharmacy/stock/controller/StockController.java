package com.pyy.pharmacy.stock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/stock")
public class StockController {
        @Value("${server.port}")
        String port;

        @RequestMapping("/qu")
        public  String qu(){
            System.out.println("bbbb");
            return "qu"+port;
        }

}
