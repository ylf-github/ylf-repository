package com.ylf.manage.util;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class Mail extends Thread{

    public int run(String destination,String subject,String code)throws Exception{
        Properties p=new Properties();
        //设置邮箱服务器地址
        p.setProperty("mail.host","smtp.163.com");
<<<<<<< HEAD
<<<<<<< HEAD
        //是否进行权限验证
        p.setProperty("mail.smtp.auth","true");
=======
=======
>>>>>>> by_19/5/8
        //设置ssl
        p.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        //是否进行权限验证
        p.setProperty("mail.smtp.auth","true");
        //邮箱发送服务器端口,这里设置为465端口
        p.setProperty("mail.smtp.port", "465");
        p.setProperty("mail.smtp.socketFactory.port", "465");
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
        //设置账号和密码
        Authenticator authenticator=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("18629450764@163.com","wangjita123");
            }
        };
        try{
            //获得会话连接
            Session session=Session.getDefaultInstance(p,authenticator);
            //构建邮件内容
            Message message=new MimeMessage(session);
            String alias=javax.mail.internet.MimeUtility.encodeText("智慧课堂");
            message.setFrom(new InternetAddress(alias+"<18629450764@163.com>"));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(destination));
            message.setSubject(subject);
            message.setContent("<font color=\"#C0C0C0\">验证码</font><br>"+"<h2 color=\"#000000\">"+code+"</h2><br>"+"<font color=\"#2f4f4f\" >" +
                    "------------------------------------------------------------------------</font><br><br>"+
                    "【智慧课堂】验证码"+code+",10分钟内有效。您正在注册成为智慧课堂用户，感谢您的支持！","text/html;charset=UTF-8");
            Transport.send(message);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

}
