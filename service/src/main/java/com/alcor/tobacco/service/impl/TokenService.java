package com.alcor.tobacco.service.impl;

import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.domain.LoginUser;
import com.alcor.tobacco.exception.BusinessException;
import com.alcor.tobacco.utils.RedisCache;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.alcor.tobacco.constant.UserConstant.JWT_SECRET;
import static com.alcor.tobacco.constant.UserConstant.REDIS_TOKEN_SAVE_KEY;

/**
 * @author guchun
 * @description TODO
 * @date 2022/5/30 19:55
 */

@Component
@Slf4j
public class TokenService {

    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    @Resource
    private RedisCache redisCache;

    /**
     * 创建token
     * @param loginUser
     * @return
     */
    public String createToken(LoginUser loginUser) {
        String uuid = UUID.randomUUID().toString();
        loginUser.setUuid(uuid);

        String tokenString = getTokenString(loginUser);
        loginUser.setToken(tokenString);

        refreshToken(loginUser);
        return tokenString;
    }

    public boolean delToken(String token) {
        LoginUser loginUser = verifyToken(token);
        return delTokenCache(loginUser.getUuid());
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public LoginUser verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0") //匹配指定的token发布者 auth0
                    .build();
            jwt = verifier.verify(token); //解码JWT ，verifier 可复用
        }catch (JWTVerificationException e){
            //无效的签名/声明
            log.warn("无效token" + e.getMessage());
            throw new BusinessException(ResCodeEnum.PARAMS_ERROR, "无效的token");
        }
        String userAccount = jwt.getClaim("userAccount").asString();
        String uuid = jwt.getClaim("UUID").asString();
        LoginUser loginUser = getTokenCache(uuid);
        if (StringUtils.hasText(userAccount) && userAccount.equals(loginUser.getUser().getUsername())) {
            // 数据脱敏 desensitization
            loginUser.getUser().setPassword(null);
            loginUser.getUser().setPhone(null);
            loginUser.getUser().setCreateTime(null);
            loginUser.getUser().setUpdateBy(null);
            loginUser.getUser().setUpdateTime(null);
            loginUser.getUser().setEnabled(null);
            loginUser.getUser().setPwdResetTime(null);

            return loginUser;
        } else {
            throw new BusinessException(ResCodeEnum.PARAMS_ERROR, "验证失败");
        }
    }

    private String getTokenString(LoginUser loginUser) {
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withIssuedAt(new Date())
                    .withClaim("userAccount", loginUser.getUser().getUsername())
                    .withClaim("UUID", loginUser.getUuid())
                    .sign(algorithm);

        } catch (JWTCreationException e) {
            log.warn(e.getMessage());
        }
        return token;
    }

    private void refreshToken(LoginUser loginUser) {
        String userKey = getTokenKey(loginUser.getUuid());
        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    private String getTokenKey(String uuid) {
        return REDIS_TOKEN_SAVE_KEY + uuid;
    }

    private LoginUser getTokenCache(String uuid) {
        String userKey = getTokenKey(uuid);
        Object cacheObject = redisCache.getCacheObject(userKey);
        if (cacheObject == null) {
            throw new BusinessException(ResCodeEnum.NOT_LOGIN, "token过期");
        }
        return (LoginUser) cacheObject;
    }

    private boolean delTokenCache(String uuid) {
        String userKey = getTokenKey(uuid);
        return redisCache.deleteObject(userKey);
    }

}
