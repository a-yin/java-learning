package com.lingb.mystudy.java.day02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @SimpleInject 简单注入，表达依赖关系
 *
 * Created by lingb on 2018/7/12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SimpleInject {
}


