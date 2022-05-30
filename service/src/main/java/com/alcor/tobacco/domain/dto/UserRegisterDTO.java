package com.alcor.tobacco.domain.dto;

import lombok.Data;

import java.io.Serializable;

import static com.alcor.tobacco.constant.UserConstant.*;

/**
 * @author guchun
 * @description 用户注册dto
 * @date 2022/5/30 16:44
 */

@Data
public class UserRegisterDTO implements Serializable{

    private String username;

    private String password;

    private Integer gender;

    private String phone;

    private Boolean isAdmin;

    public Boolean isValid() {
        return this.getUsername().length() < USER_ACCOUNT_MIN_SIZE ||
                this.getUsername().length() > USER_ACCOUNT_MAXSIZE ||
                this.getPassword().length() > USER_PASSWORD_MAXSIZE ||
                this.getPassword().length() < USER_PASSWORD_MIN_SIZE;
    }

}
