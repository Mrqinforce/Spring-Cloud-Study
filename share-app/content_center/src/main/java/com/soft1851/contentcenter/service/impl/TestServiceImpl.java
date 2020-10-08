package com.soft1851.contentcenter.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.soft1851.contentcenter.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2020/10/6
 * @Version 1.0
 **/
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    //指定sentinel的资源名称
    @Override
    @SentinelResource("common")

    public String commonMethod() {
        log.info("commonMethod....");
        return "common";
    }
}
