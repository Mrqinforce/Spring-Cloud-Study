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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {
    private String wxId;
    private String wxNickname;
    private String avatarUrl;
}