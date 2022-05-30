package com.alcor.tobacco.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guchun
 * @description TODO
 * @date 2022/5/30 19:48
 */
@Data
public class UserLoginDTO implements Serializable {

    private String username;

    private String password;
}
