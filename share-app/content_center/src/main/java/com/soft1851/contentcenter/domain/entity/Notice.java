package com.soft1851.contentcenter.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2020/10/4
 * @Version 1.0
 **/
@Table(name = "notice")
@ApiModel("公告")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    @ApiModelProperty(name = "id", value = "公告id")
    private Integer id;

    @ApiModelProperty(name = "content", value = "公告内容")
    private String content;

    @ApiModelProperty(name = "showFlag", value = "是否显示 0：否 1：是")
    private Boolean showFlag;

    @ApiModelProperty(name = "createTime", value = "创建时间")

    //东八区时区

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
