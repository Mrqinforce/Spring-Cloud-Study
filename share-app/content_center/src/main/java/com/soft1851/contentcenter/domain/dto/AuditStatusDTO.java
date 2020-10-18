package com.soft1851.contentcenter.domain.dto;

import com.soft1851.contentcenter.domain.enums.AuditStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Qin jian
 * @description TODO
 * @Data 2020/10/7
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuditStatusDTO {

    private AuditStatusEnum auditStatusEnum;

    private String reason;

}
