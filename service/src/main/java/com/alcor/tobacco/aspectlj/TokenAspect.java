package com.alcor.tobacco.aspectlj;

import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.exception.BusinessException;
import com.alcor.tobacco.service.impl.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author guchun
 * @description TODO
 * @date 2022/5/30 20:10
 */

@Aspect
@Component
@Slf4j
public class TokenAspect {

    @Resource
    TokenService tokenService;

    @Pointcut("@annotation(com.alcor.tobacco.aspectlj.config.TokenVerify)")
    public void TokenAspect() {}

    @Around("TokenAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            throw new BusinessException(ResCodeEnum.NULL_ERROR, "token不能为空");
        }
        tokenService.verifyToken(token);
        return joinPoint.proceed();
    }
}
