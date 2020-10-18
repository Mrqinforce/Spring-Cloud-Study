package com.soft1851.contentcenter.service;

import com.github.pagehelper.PageInfo;
import com.soft1851.contentcenter.domain.dto.ContributeShareDTO;
import com.soft1851.contentcenter.domain.dto.ExchangeDTO;
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

    /**
     * 根据用户查询我的投稿列表
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return
     */
    PageInfo<Share> queryMyContribute(Integer pageNo,Integer pageSize,Integer userId);

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

    /**
     * 积分兑换资源
     *
     * @param exchangeDTO
     * @return Share
     */
    Share exchange(ExchangeDTO exchangeDTO);

    /**
     * 根据用户id查询我的兑换
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return
     */
    PageInfo<Share> MyExchange(Integer pageNo,Integer pageSize,Integer userId);
}


