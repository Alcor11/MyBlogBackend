package com.alcor.tobacco.domain.dto;

import lombok.Data;

/**
 * @author guchun
 * @description 用户注册dto
 * @date 2022/5/30 16:44
 */

@Data
public class UserRegisterDTO {

    private String userAccount;

    private String userPassword;

    private Integer gender;

    private String userName;

    private String userPhone;

}
