package com.alcor.tobacco.aspectlj.config;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyQuery {
      String value();
      String column();
}
