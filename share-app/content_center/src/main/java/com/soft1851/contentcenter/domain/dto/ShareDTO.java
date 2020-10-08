package com.soft1851.contentcenter.domain.dto;

import com.soft1851.contentcenter.domain.entity.Share;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qj
 * @className ShareDTO
 * @Description TODO
 * @Date 2020/9/29
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("分享详情，带发布人昵称")
@Data
public class ShareDTO {
//    /**
//     * id
//     */
//    private Integer id;
//
//    /**
//     * 发布人id
//     */
//    private Integer userId;
//
//    /**
//     * 标题
//     */
//    private String title;
//
//    /**
//     * 创建时间
//     */
//    private Date createTime;
//
//    /**
//     * 修改时间
//     */
//    private Date updateTime;
//
//    /**
//     * 是否原创 0:否 1:是
//     */
//    private Boolean isOriginal;
//
//    /**
//     * 作者
//     */
//    private String author;
//
//    /**
//     * 封面
//     */
//    private String cover;
//
//    /**
//     * 概要信息
//     */
//    private String summary;
//
//    /**
//     * 价格（需要的积分）
//     */
//    private Integer price;
//
//    /**
//     * 下载地址
//     */
//    private String downloadUrl;
//
//    /**
//     * 下载数
//     */
//    private Integer buyCount;
//
//    /**
//     * 是否显示 0:否 1:是
//     */
//    private Boolean showFlag;
//
//    /**
//     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
//     */
//    private String auditStatus;
//
//    /**
//     * 审核不通过原因
//     */
//    private String reason;
//

    @ApiModelProperty(name = "share", value = "分享资源信息")
    private Share share;

    @ApiModelProperty(name = "wxNickname", value = "发布人昵称")
    private String wxNickname;

    private UserDTO userDTO;
}
