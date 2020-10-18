package com.soft1851.contentcenter.feignclient;

import com.soft1851.contentcenter.configuration.UserCenterFeignConfiguration;
import com.soft1851.contentcenter.domain.dto.ResponseDTO;
import com.soft1851.contentcenter.domain.dto.UserAddBonusMsgDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
     * http://user-center/users/{id}
     *
     * @param id
     * @return UserDTO
     */
    @GetMapping("/users")
    ResponseDTO findUserById(@RequestParam Integer id);

    /**
     * hello测试
     * @return String
     */
    @GetMapping("/user/hello")
    String getHello();

    /**
     * 加积分
     * @param userAddBonusMsgDto
     * @return
     */
    @RequestMapping(value = "/users/addBonus", method = RequestMethod.POST)
    UserAddBonusMsgDTO addBonusById(@RequestBody UserAddBonusMsgDTO userAddBonusMsgDto);
}
