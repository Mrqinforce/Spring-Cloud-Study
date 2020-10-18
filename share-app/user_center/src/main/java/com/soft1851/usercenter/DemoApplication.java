package com.soft1851.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
import com.purgeteam.dispose.starter.annotation.EnableGlobalDispose;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@MapperScan(basePackages = "com.soft1851.usercenter.dao")
@EnableFeignClients
@EnableGlobalDispose
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
