package com.soft1851.gateway;

import lombok.Data;

import java.time.LocalTime;

/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2020/10/9
 * @Version 1.0
 **/
@Data
public class TimeBetweenConfig {

    private LocalTime start;
    private LocalTime end;
}