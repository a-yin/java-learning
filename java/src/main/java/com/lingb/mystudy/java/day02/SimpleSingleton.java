package com.lingb.mystudy.java.day02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @SimpleSingleton 单例模式
 *
 * Created by lingb on 2018/7/12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SimpleSingleton {
}
