package com.lingb.mystudy.java.day15;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.04.03 22:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String password;
    private String loginDateTime;
    private String loginIp;
    private String mobile;
}
