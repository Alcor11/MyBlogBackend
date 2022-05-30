package com.alcor.tobacco.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guchun
 * @description TODO
 * @date 2022/5/30 19:58
 */
@Data
public class LoginUser implements Serializable {

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * redis验证uuid
     */
    private String uuid;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;


    /**
     * 用户信息
     */
    private SysUser user;

}
