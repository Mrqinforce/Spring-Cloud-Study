package com.soft1851.usercenter.service.impl;

import com.soft1851.usercenter.dao.BonusEventLogMapper;
import com.soft1851.usercenter.dao.UserMapper;
import com.soft1851.usercenter.domain.dto.LoginDTO;
import com.soft1851.usercenter.domain.dto.ResponseDTO;
import com.soft1851.usercenter.domain.dto.UserAddBonusMsgDTO;
import com.soft1851.usercenter.domain.dto.UserSignInDTO;
import com.soft1851.usercenter.domain.entity.BonusEventLog;
import com.soft1851.usercenter.domain.entity.User;
import com.soft1851.usercenter.service.UserService;
import com.soft1851.usercenter.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author Qin jian
 * @className UserServiceImpl
 * @Description TODO
 * @Date 2020/9/29
 * @Version 1.0
 **/
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public User findById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);

    }

    @Override
    public void addBonusById(UserAddBonusMsgDTO userAddBonusMsgDto) {
//        User user = userMapper.selectByPrimaryKey(userAddBonusMsgDto.getUserId());
//        user.setBonus(user.getBonus() + userAddBonusMsgDto.getBonus());
//        this.userMapper.updateByPrimaryKeySelective(user);
//
//        //2、写积分日志
//        this.bonusEventLogMapper.insert(BonusEventLog.builder()
//                .userId(user.getId())
//                .value(userAddBonusMsgDto.getBonus())
//                .event("CONTRIBUTE")
//                .createTime(LocalDateTime.now())
//                .description("投稿加积分")
//                .build());
//        return user;
        System.out.println(userAddBonusMsgDto);
        // 1. 为用户加积分
        Integer userId = userAddBonusMsgDto.getUserId();
        Integer bonus = userAddBonusMsgDto.getBonus();
        User user = this.userMapper.selectByPrimaryKey(userId);

        user.setBonus(user.getBonus() + bonus);
        this.userMapper.updateByPrimaryKeySelective(user);

        // 2. 记录日志到bonus_event_log表里面
        this.bonusEventLogMapper.insert(
                BonusEventLog.builder()
                        .userId(userId)
                        .value(bonus)
                        .event(userAddBonusMsgDto.getEvent())
                        .createTime(new Date())
                        .description(userAddBonusMsgDto.getDescription())
                        .build()
        );
        log.info("积分添加完毕...");
    }

    @Override
    public ResponseDTO signIn(UserSignInDTO signInDTO) {
        User user = this.userMapper.selectByPrimaryKey(signInDTO.getUserId());
        if (user == null){
            throw new IllegalArgumentException("该用户不存在!");
        }
        Example example = new Example(BonusEventLog.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("id DESC");
        criteria.andEqualTo("userId",signInDTO.getUserId());
        criteria.andEqualTo("event","SIGN_IN");
        List<BonusEventLog> bonusEventLog = this.bonusEventLogMapper.selectByExample(example);
        BonusEventLog bonusEventLog1 = bonusEventLog.get(0);
        Date date = bonusEventLog1.getCreateTime();
        try {
            if (DateUtil.checkAllotSigin(date) == 0){
                this.bonusEventLogMapper.insert(BonusEventLog.builder()
                        .userId(signInDTO.getUserId())
                        .event("SIGN_IN")
                        .value(20)
                        .description("签到加积分")
                        .createTime(new Date())
                        .build());
                System.out.println(signInDTO.getUserId());
                user.setBonus(user.getBonus() + (Integer) 20);
                this.userMapper.updateByPrimaryKeySelective(user);
                return new ResponseDTO(true,"200","签到成功",user.getWxNickName()+"用户签到成功",1l);
            }
            else if (DateUtil.checkAllotSigin(date) == 1){
                return new ResponseDTO(false,"201","签到失败",user.getWxNickName()+"今天已经签到过了",1l);
            }
            else if (DateUtil.checkAllotSigin(date) == 2){
                return new ResponseDTO(false,"202","签到失败",user.getWxNickName()+"用户，今天数据错乱了",1l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseDTO(true,"200","签到成功",user.getWxNickName()+"签到成功",1l);
    }

    @Override
    public User login(LoginDTO loginDTO) {
        //先根据wxId查找用户
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        System.out.println(loginDTO.getWxId());
        criteria.andEqualTo("wxId", loginDTO.getWxId());
        List<User> users = this.userMapper.selectByExample(example);
        //没找到，是新用户，直接注册
        if (users.size() == 0) {
            User saveUser = User.builder()
                    .wxId(loginDTO.getWxId())
                    .avatarUrl(loginDTO.getAvatarUrl())
                    .wxNickName(loginDTO.getWxNickname())
                    .roles("user")
                    .bonus(100)
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();
            this.userMapper.insertSelective(saveUser);
            return saveUser;
        }
        return users.get(0);
    }

    @Override
    public ResponseDTO checkIsSign(UserSignInDTO signInDTO) {
        User user = this.userMapper.selectByPrimaryKey(signInDTO.getUserId());
        if (user == null){
            throw new IllegalArgumentException("该用户不存在!");
        }
        Example example = new Example(BonusEventLog.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("id DESC");
        criteria.andEqualTo("userId",signInDTO.getUserId());
        criteria.andEqualTo("event","SIGN_IN");
        List<BonusEventLog> bonusEventLog = this.bonusEventLogMapper.selectByExample(example);
        BonusEventLog bonusEventLog1 = bonusEventLog.get(0);
        Date date = bonusEventLog1.getCreateTime();
        try {
            if (DateUtil.checkAllotSigin(date) == 0){
                return new ResponseDTO(true,"200","该用户还没有签到","可以签到",1l);
            }
            else if (DateUtil.checkAllotSigin(date) == 1){
                return new ResponseDTO(false,"201","已经签到了","不可以签到",1l);
            }
            else if (DateUtil.checkAllotSigin(date) == 2){
                return new ResponseDTO(false,"202","数据出错了","不可以签到",1l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseDTO(true,"200","该用户还没有签到","可以签到",1l);
    }

}
