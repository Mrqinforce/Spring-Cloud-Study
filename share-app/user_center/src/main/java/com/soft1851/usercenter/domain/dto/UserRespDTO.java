package com.soft1851.usercenter.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2020/10/13
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRespDTO {
    private Integer id;
    private String wxNickName;
    private Integer bonus;
    private String avatarUrl;
}
