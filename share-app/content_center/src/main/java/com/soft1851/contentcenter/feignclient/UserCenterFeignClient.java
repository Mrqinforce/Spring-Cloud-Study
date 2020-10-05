package com.soft1851.contentcenter.feignclient;

import com.soft1851.contentcenter.configuration.UserCenterFeignConfiguration;
import com.soft1851.contentcenter.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author qj
 * @className UserCenterFeignClient
 * @Description TODO
 * @Date 2020/9/29
 * @Version 1.0
 **/
@FeignClient(name = "user-center",configuration = UserCenterFeignConfiguration.class)
//@FeignClient(name = "user-center",configuration = GlobalFeignConfiguration.class)
//@FeignClient(name ="user-center")

public interface UserCenterFeignClient {
    /**
     * http://user-center/user/{id}
     *
     * @param id
     * @return UserDTO
     */
    @GetMapping("/user/{id}")
    UserDTO findUserById(@PathVariable Integer id);

    /**
     * hello测试
     * @return String
     */
    @GetMapping("/user/hello")
    String getHello();
}