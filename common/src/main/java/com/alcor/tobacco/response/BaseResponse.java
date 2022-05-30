package com.alcor.tobacco.response;

import java.io.Serializable;

/**
 * @author guchun
 * @description 返回结果类
 * @date 2022/5/30 16:17
 */
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    private String description;

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this(code, data, message, "");
    }

    public BaseResponse(int code, T data) {
        this(code, data, "", "");
    }

    public BaseResponse(int code) {
        this(code, null, "", "");
    }
}
