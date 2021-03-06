package com.soft1851.contentcenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhao
 * @className HelloHandler
 * @Description TODO
 * @Date 2020/9/23
 * @Version 1.0
 **/
@RestController
@RequestMapping("/consumer")
public class HelloHandler {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String getHello(){
        return restTemplate.getForObject("http://101.201.142.75:60101/user/hello",String.class);
    }
    @GetMapping("/hello1")
    public String getHello1(){
        return "This is content-center";
    }
}
