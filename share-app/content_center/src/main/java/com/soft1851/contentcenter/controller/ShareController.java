package com.soft1851.contentcenter.controller;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.soft1851.contentcenter.domain.dto.ContributeShareDTO;
import com.soft1851.contentcenter.domain.dto.ExchangeDTO;
import com.soft1851.contentcenter.domain.dto.ShareDTO;
import com.soft1851.contentcenter.domain.entity.Share;
import com.soft1851.contentcenter.service.ShareService;
import com.soft1851.contentcenter.util.JwtOperator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qj
 * @className ShareController
 * @Description TODO
 * @Date 2020/9/29
 * @Version 1.0
 **/

@Slf4j
@RestController
@RequestMapping(value = "/share")
@Api(tags = "分享接口",value = "提供分享相关的Rest API")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {

    private final ShareService shareService;
    private final JwtOperator jwtOperator;
    // private final RestTemplate restTemplate;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "通过id查询",notes = "通过id查询")
    public ShareDTO findById(@PathVariable Integer id){
        return this.shareService.findById(id);
    }

    @GetMapping(value = "/query")
    @ApiOperation(value = "分享列表",notes = "分享列表")
    public List<Share> query(
            @RequestParam(required = false) String title,
            @RequestParam(required = false,defaultValue = "1") Integer pageNo,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize,
            @RequestHeader(value = "X-Token",required = false) String token){
        if(pageSize > 100){
            pageSize = 100;
        }
        Integer userId = null;
        if (StringUtil.isNotBlank(token)){
            System.out.println(token);
            Claims claims = this.jwtOperator.getClaimsFromToken(token);
            log.info(claims.toString());
            userId = (Integer)claims.get("id");
        }else {
            log.info("没有token");
        }
        return this.shareService.query(title,pageNo,pageSize,userId).getList();
    }

    @PostMapping(value = "/contribute/share")
    @ApiOperation(value = "分享投稿",notes = "分享投稿")
    public Share ContributeShare(@RequestBody ContributeShareDTO contributeShareDTO){
        return shareService.ContributeShare(contributeShareDTO);
    }

    @GetMapping(value = "/query/myContribution")
    @ApiOperation(value = "我的分享列表",notes = "我的分享列表")
    public List<Share> query(
            @RequestParam(required = false,defaultValue = "1") Integer pageNo,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) Integer userId) {
        if (pageSize > 100) {
            pageSize = 100;
        }
        return this.shareService.queryMyContribute(pageNo,pageSize,userId).getList();
    }

    @PostMapping("/exchange")
    @ApiOperation(value = "兑换分享资源",notes = "兑换分享资源")
    public Share exchange(@RequestBody ExchangeDTO exchangeDto) {
        System.out.println(exchangeDto + ">>>>>>>>>>>>");
        return this.shareService.exchange(exchangeDto);
    }

    @GetMapping(value = "/myExchange")
    @ApiOperation(value = "我的兑换列表",notes = "我的兑换列表")
    public List<Share> myExchange(
            @RequestParam(required = false,defaultValue = "1") Integer pageNo,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) Integer userId) {
        if (pageSize > 100) {
            pageSize = 100;
        }
        return this.shareService.MyExchange(pageNo,pageSize,userId).getList();
    }


}