package com.soft1851.contentcenter.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Qin jian
 * @description TODO
 * @Data 2020/10/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeDTO {
    private Integer userId;
    private Integer shareId;
}
