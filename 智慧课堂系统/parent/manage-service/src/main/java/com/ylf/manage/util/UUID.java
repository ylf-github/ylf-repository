package com.ylf.manage.util;

public class UUID {
    public static String getUUID(){   //返回32位随机码(数据库主键)
        String id=java.util.UUID.randomUUID().toString();
        return id.replaceAll("-","");
    }

    public static String getCode(){   //返回6位随机数(验证码)
        int code= (int)((Math.random()*9+1)*100000);
        return  String.valueOf(code);
    }
}
