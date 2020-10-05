package com.soft1851.contentcenter.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2020/9/30
 * @Version 1.0
 **/
public class UserCenterFeignConfiguration {
    @Bean
    public Logger.Level level(){
        //让feign打印所有请求细节
        return Logger.Level.FULL;
    }
}
