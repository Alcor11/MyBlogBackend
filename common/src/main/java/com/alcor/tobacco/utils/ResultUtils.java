package com.alcor.tobacco.utils;

import com.alcor.tobacco.constant.ResCodeEnum;
import com.alcor.tobacco.response.BaseResponse;

/**
 * @author guchun
 * @description 返回结果工具类
 * @date 2022/5/30 16:22
 */
public class ResultUtils {

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "success");
    }

    public static <T> BaseResponse<T> error(ResCodeEnum errCode) {
        return new BaseResponse<>(errCode.getCode());
    }

    public static BaseResponse error(int code, String message, String description) {
        return new BaseResponse(code, null, message, description);
    }

    public static BaseResponse error(ResCodeEnum errorCode, String message, String description) {
        return new BaseResponse(errorCode.getCode(), null, message, description);
    }

    public static BaseResponse error(ResCodeEnum errorCode, String description) {
        return new BaseResponse(errorCode.getCode(), errorCode.getMessage(), description);
    }
}
