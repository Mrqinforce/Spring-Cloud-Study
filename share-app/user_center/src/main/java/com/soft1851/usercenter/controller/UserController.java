package com.soft1851.usercenter.controller;

import com.soft1851.usercenter.domain.dto.*;
import com.soft1851.usercenter.domain.entity.User;
import com.soft1851.usercenter.service.UserService;
import com.soft1851.usercenter.util.JwtOperator;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qj
 * @className UserController
 * @Description TODO
 * @Date 2020/9/29
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserController {
    private final UserService userService;
    private final JwtOperator jwtOperator;

    @GetMapping
    public User findUserById(@RequestParam Integer id) {
        log.info("我被请求啦...");
        return this.userService.findById(id);
    }

    @PostMapping("/addBonus")
    @ApiOperation(value = "根据用户id加积分",notes = "根据用户id加积分")
    public User addBonusById(@RequestBody  UserAddBonusMsgDTO userAddBonusMsgDto){
        Integer userId = userAddBonusMsgDto.getUserId();
        userService.addBonusById(
                UserAddBonusMsgDTO.builder()
                        .userId(userId)
                        .bonus(userAddBonusMsgDto.getBonus())
                        .description(userAddBonusMsgDto.getDescription())
                        .event(userAddBonusMsgDto.getEvent())
                        .build()
        );
        return this.userService.findById(userId);
    }

    @PostMapping(value = "/login")
    public LoginRespDTO getUser(@RequestBody LoginDTO loginDto){
        User user = this.userService.login(loginDto);
        //颁发token
        Map<String,Object> userInfo = new HashMap<>(3);
        userInfo.put("id",user.getId());
        userInfo.put("wxNickName",user.getWxNickName());
        userInfo.put("role",user.getRoles());
        String token = jwtOperator.generateToken(userInfo);

        log.info(
                "{}登录成功，生成的token = {},有效期到:{}",
                user.getWxNickName(),
                token,
                jwtOperator.getExpirationTime()
        );
        ResponseDTO responseDTO = this.userService.checkIsSign(UserSignInDTO.builder().userId(user.getId()).build());
        int isUserSignin = 0;
        if (responseDTO.getCode()=="200"){
            isUserSignin = 0;
        }else {
            isUserSignin = 1;
        }
        System.out.println(responseDTO);
        return LoginRespDTO.builder()
                .user(UserRespDTO.builder()
                        .id(user.getId())
                        .avatarUrl(user.getAvatarUrl())
                        .wxNickName(user.getWxNickName())
                        .bonus(user.getBonus())
                        .build())
                .token(JwtTokenRespDTO
                        .builder()
                        .token(token)
                        .expirationTime(jwtOperator.getExpirationTime().getTime())
                        .build())
                .isUserSignin(isUserSignin)
                .build();
    }

    @PostMapping(value = "/signin")
    public ResponseDTO signIn(@RequestBody UserSignInDTO userSignInDTO){
        return userService.signIn(userSignInDTO);
    }

}
