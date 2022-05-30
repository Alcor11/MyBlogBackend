package com.alcor.tobacco.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guchun
 * @description TODO
 * @date 2022/5/30 19:47
 */
@Data
public class UserLoginVO implements Serializable {

    private String username;

    private String token;

    private String gender;

    private String phone;

}
