package com.soft1851.usercenter.service;

import com.soft1851.usercenter.domain.entity.User;

/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author qin jian
 * @Date 2020/9/29
 * @Version 1.0
 **/
public interface UserService {

    /**
     * 根据id获得用户详情
     * @param id
     * @return User
     */
    User findById(Integer id);

}