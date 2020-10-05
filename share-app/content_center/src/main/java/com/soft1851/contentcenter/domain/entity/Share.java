package com.soft1851.contentcenter.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author qj
 * @className Share
 * @Description TODO
 * @Date 2020/9/29
 * @Version 1.0
 **/
@Table(name = "share")
@ApiModel("分享")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Share {

    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(name = "id", value = "分享id")
    private Integer id;

    @Column(name = "user_id")
    @ApiModelProperty(name = "userId", value = "分享人id")
    private Integer userId;

    @Column(name = "title")
    @ApiModelProperty(name = "title", value = "分享内容标题")
    private String title;

    @Column(name = "create_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Timestamp createTime;

    @Column(name = "update_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Timestamp updateTime;

    @Column(name = "is_original")
    @ApiModelProperty(name = "isOriginal", value = "是否显示 0：否 1：是")

    private Integer isOriginal;

    @Column(name = "author")
    @ApiModelProperty(name = "author", value = "资源作者")
    private String author;

    @Column(name = "cover")
    @ApiModelProperty(name = "cover", value = "资源封面图URL")
    private String cover;

    @Column(name = "summary")
    @ApiModelProperty(name = "summary", value = "资源摘要")
    private String summary;

    @Column(name = "price")
    @ApiModelProperty(name = "price", value = "下载需要的积分")
    private Integer price;

    @Column(name = "download_url")
    @ApiModelProperty(name = "downloadUrl", value = "下载地址")
    private String downloadUrl;

    @Column(name = "buy_count")
    @ApiModelProperty(name = "butCount", value = "下载次数")
    private String buyCount;

    @Column(name = "show_flag")
    @ApiModelProperty(name = "showFlag", value = "是否显示 0：否 1：是")

    private Integer showFlag;

    @Column(name = "audit_status")
    @ApiModelProperty(name = "auditStatus", value = "审核状态 NOT_YET： 待审核 PASSED：审核通过 REJECTED：审核不通过 ")
    private String auditStatus;

    @Column(name = "reason")
    @ApiModelProperty(name = "reason", value = "审核不通过原因")
    private String reason;
}