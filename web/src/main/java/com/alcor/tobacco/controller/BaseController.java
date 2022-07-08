package com.alcor.tobacco.controller;

import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.exception.BusinessException;
import com.alcor.tobacco.service.impl.TokenService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author guchun
 * @description TODO
 * @date 2022/5/30 20:13
 */

@RestController
public class BaseController {

    @Resource
    TokenService tokenService;

    protected LoginUser getLoginUser(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Access-Token");
        System.out.println(token);
        if (!StringUtils.hasText(token)) {
            throw new BusinessException(ResCodeEnum.PARAMS_ERROR, "token不存在");
        }
        return tokenService.verifyToken(token);
    }

    protected boolean offLineUser(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        return tokenService.delToken(token);
    }
}
