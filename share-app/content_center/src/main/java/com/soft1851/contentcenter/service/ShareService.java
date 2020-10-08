package com.soft1851.contentcenter.service;

import com.github.pagehelper.PageInfo;
import com.soft1851.contentcenter.domain.dto.ContributeShareDTO;
import com.soft1851.contentcenter.domain.dto.ShareAuditDTO;
import com.soft1851.contentcenter.domain.dto.ShareDTO;
import com.soft1851.contentcenter.domain.entity.Share;

/**
 * @author qj
 * @className ShareService
 * @Description TODO
 * @Date 2020/9/29
 * @Version 1.0
 **/

public interface ShareService {
    /**
     * 获得分享详情
     * @param id
     * @return  ShareDTO
     */
    ShareDTO findById(Integer id);

    /**
     * 根据标题模糊查询某个用户的分享列表数据， title为空则为所有数据，查询结果分页
     * @param title
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return Pageinfo<Share>
     */
    PageInfo<Share> query(String title, Integer pageNo, Integer pageSize, Integer userId);

//    String getHello();
    /** 投稿
     * @param contributeShareDTO
     */
    Share ContributeShare(ContributeShareDTO contributeShareDTO);

    /**
     * @param id
     * @param shareAuditDTO
     * return Share auditById
     */
    Share auditById(Integer id, ShareAuditDTO shareAuditDTO);
}


