package com.alcor.tobacco.aspectlj.config;

import java.lang.annotation.*;

/**
 * @author guchun
 * @description TODO
 * @date 2022/5/30 20:08
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface TokenVerify {
}
