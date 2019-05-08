package com.ylf.manage.util;

import org.springframework.util.DigestUtils;

public class MD5 {
    public static String md5(String pass)  {
        String temp = DigestUtils.md5DigestAsHex(pass.getBytes());
        String password=DigestUtils.md5DigestAsHex(temp.getBytes());
        return password;
    }
}
