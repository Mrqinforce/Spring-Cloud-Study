package com.soft1851.contentcenter;

import org.springframework.web.client.RestTemplate;

/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2020/10/6
 * @Version 1.0
 **/
public class SentinelTest {
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i <100; i++) {
            String object = restTemplate.getForObject("http://localhost:8082/test/byResource",String.class);
            System.out.println(object);
//            Thread.sleep(1000);
        }
    }
}
