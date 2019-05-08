package com.ylf.manage.controller;

import com.ylf.manage.entity.Course;
import com.ylf.manage.entity.Score;
import com.ylf.manage.entity.Uemail;
import com.ylf.manage.entity.User;
import com.ylf.manage.iservice.Score_iserv;
import com.ylf.manage.iservice.User_iserv;
import com.ylf.manage.util.MD5;
import com.ylf.manage.util.Mail;
import com.ylf.manage.util.UUID;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {
     @Autowired
     private User_iserv service;
     @Resource(name="redisTemplate")
     private RedisTemplate redisTemplate;
     @Autowired
     private Score_iserv sService;

     @RequestMapping(value = "/user/validate" )//注册时的邮箱验证
     @ResponseBody                             //uEmail邮箱
     @CrossOrigin
     public JSONObject validate(String uEmail){
         if(uEmail!=null){
             User user=service.findOne(uEmail);
             if(user!=null){
                 JSONObject msg=new JSONObject();
                 msg.put("msg","此邮箱已注册");
                 return msg;
             }
             String code=UUID.getCode();  //获取验证码
             try{
                 new Mail().run(uEmail,"智慧教室",code); //发送验证码
                 redisTemplate.opsForValue().set(uEmail,code); //验证码放到redis
                 redisTemplate.expire(uEmail,60*10, TimeUnit.SECONDS);  //设置过期时间10分钟，防止内存溢出                                         // 设置过期时间
                 JSONObject msg=new JSONObject();
                 msg.put("msg","发送成功");
                 return msg;
             }catch (Exception e){
                 e.printStackTrace();
                 JSONObject msg=new JSONObject();
                 msg.put("msg","发送失败");
                 return msg;
             }
         }
         JSONObject msg=new JSONObject();
         msg.put("msg","发送失败");
         return msg;

     }

     @RequestMapping(value = "/user/add")
     @ResponseBody
     @CrossOrigin
     public JSONObject addUser( User user, String code){        //添加用户
         if(code==null){                                        //user包含用户姓名、密码、邮箱
             JSONObject msg=new JSONObject();                   //code验证码
             msg.put("msg","验证码错误");
             return msg;
         }
         String redisCode=(String) redisTemplate.opsForValue().get(user.getuEmail());//从redis获取验证码
         if(!code.equals(redisCode)){
             JSONObject msg=new JSONObject();
             msg.put("msg","验证码错误");
             return msg;
         }
         else{
             if(user.getuPassword()!=null)
             user.setuPassword(MD5.md5(user.getuPassword()));
             int n=service.add(user);
             if(n>0){
                 redisTemplate.delete(user.getuEmail());  //验证完删除，防止内存溢出
                 JSONObject msg=new JSONObject();
                 msg.put("msg","注册成功");
                 return msg;
             }
             else{
                 JSONObject msg=new JSONObject();
                 msg.put("msg","注册失败");
                 return msg;
             }
         }
     }

     @RequestMapping("/user/login")          //登陆
     @ResponseBody                           //user包含用户账号和密码
     @CrossOrigin
     public JSONObject login(User user, HttpSession session, HttpServletRequest request){
         if(user.getuPassword()!=null&&user.getuEmail()!=null){
             String pass=MD5.md5(user.getuPassword());
             user.setuPassword(pass);
             List<User> list=service.findAll();
             if(list.size()>0){
                 for(int i=0;i<list.size();i++){
                     if(user.getuEmail().equals(list.get(i).getuEmail())&&user.getuPassword().equals(list.get(i).getuPassword())){
                         session.setAttribute("user",user.getuEmail());
                         JSONObject msg=new JSONObject();
                         msg.put("msg","1");
                         return msg;
                     }
                 }
             }
         }
         JSONObject msg=new JSONObject();
         msg.put("msg","账号或密码不正确");
         return msg;
     }

     @RequestMapping("/user/info")
     @ResponseBody
     @CrossOrigin
     public User getUserInfo(String u_id){  //返回用户信息,u_id用户id
         User user=service.findOne(u_id);
         return user;
     }

     @RequestMapping("/user/upd/pass")           //用户忘记密码通过验证更改密码
     @ResponseBody
     @CrossOrigin
     public JSONObject updatePass(User user,String code){
         if(code==null){
             JSONObject msg=new JSONObject();
             msg.put("msg","验证码错误");
             return msg;
         }
         String redisCode=(String) redisTemplate.opsForValue().get(user.getuEmail());//从redis获取验证码
         if(!code.equals(redisCode)){
             JSONObject msg=new JSONObject();
             msg.put("msg","验证码错误");
             return msg;
         }
         else {
             if(user.getuPassword()!=null&&user.getuEmail()!=null){
                 User isTure=service.findOne(user.getuEmail());
                 if(isTure==null){
                     JSONObject msg=new JSONObject();
                     msg.put("msg","用户不存在");
                     return msg;
                 }
                 user.setuPassword(MD5.md5(user.getuPassword()));
                 int n=service.updPass(user);
                 if(n>0){
                     redisTemplate.delete(user.getuEmail());  //验证完删除，防止内存溢出
                     JSONObject msg=new JSONObject();
                     msg.put("msg","1");
                     return msg;
                 }
                 else{
                     JSONObject msg=new JSONObject();
                     msg.put("msg","修改失败");
                     return msg;
                 }
             }
             else{
                 JSONObject msg=new JSONObject();
                 msg.put("msg","修改失败");
                 return msg;
             }

         }

     }

     @RequestMapping("/user/update")
     @ResponseBody
     @CrossOrigin
     public JSONObject updateUser(User user,String u_id){          //更新用户信息
         if(user!=null){                                           //user包含用户姓名和密码,u_id用户id
             user.setuEmail(u_id);
             if(user.getuPassword()!=null){
                 String pass=MD5.md5(user.getuPassword());
                 user.setuPassword(pass);
             }
             int n=service.upd(user);
             if(n>0){
                 JSONObject msg=new JSONObject();
                 msg.put("msg","1");
                 return msg;
             }
             else{
                 JSONObject msg=new JSONObject();
                 msg.put("msg","修改失败");
                 return msg;
             }
         }
         JSONObject msg=new JSONObject();
         msg.put("msg","修改失败");
         return msg;

     }

     @RequestMapping("/user/update/id")
     @ResponseBody
     @CrossOrigin
     public JSONObject updateId(String new_email,String old_email,String code,HttpSession session){         //更新用户邮箱
         if(new_email!=null&&code!=null){                                                                   //new_email新邮箱，old_email旧邮箱
             String redisCode=(String) redisTemplate.opsForValue().get(new_email);                          //code验证码
             if(!code.equals(redisCode)){
                 JSONObject msg=new JSONObject();
                 msg.put("msg","验证码不正确");
                 return msg;
             }
             Uemail uemail=new Uemail();
             uemail.setOld_email(old_email);
             uemail.setNew_email(new_email);
             int n=service.updId(uemail);
             if(n>0){
                 session.setAttribute("user",new_email);
                 redisTemplate.delete(new_email);  //验证完删除，防止内存溢出
                 JSONObject msg=new JSONObject();
                 msg.put("msg","1");
                 return msg;
             }
             else {
                 JSONObject msg=new JSONObject();
                 msg.put("msg","修改邮箱失败");
                 return msg;
             }
         }
         JSONObject msg=new JSONObject();
         msg.put("msg","修改邮箱失败");
         return msg;


     }


     @RequestMapping("/user/join/course")
     @ResponseBody
     @CrossOrigin
     public JSONObject joinCourse(String u_id,String c_id){   //加入班课,c_id课程id
         User user=service.findOne(u_id);                     //u_id用户id
         if(u_id==null||c_id==null){
             JSONObject msg=new JSONObject();
             msg.put("msg","加入班课失败");
             return msg;
         }
         Score score=new Score();
         score.setuName(user.getuName());
         score.setuEmail(u_id);
         score.setcId(c_id);
         int n=service.joinCourse(u_id,c_id);
         int z=sService.add(score);
         if(n+z>1){
             JSONObject msg=new JSONObject();
             msg.put("msg","1");
             return msg;
         }
         else{
             JSONObject msg=new JSONObject();
             msg.put("msg","班课不存在");
             return msg;
         }
     }

     @RequestMapping("/user/find/course/join")       //返回加入的班课
     @ResponseBody                                   //u_id用户id
     @CrossOrigin
     public List<Course> findJoinCourse(String u_id){
         return service.findAllJoinCourse(u_id);
     }

    @RequestMapping("/user/find/course/create")
    @ResponseBody
    @CrossOrigin
    public List<Course> findCreateCourse(String u_id){  //返回创建的班课
         return service.findAllCreateCourse(u_id);      //u_id用户id
    }

    @RequestMapping("/user/name")
    @ResponseBody
    @CrossOrigin
    public JSONObject getUserName(String id){      //返回用户名
<<<<<<< HEAD
<<<<<<< HEAD
          String name="匿名用户";                   //id用户id
=======
          String name="";                          //id用户id
>>>>>>> zhkt-ok
=======
          String name="";                          //id用户id
>>>>>>> by_19/5/8
          User user=service.findOne(id);
          if(user==null){
              JSONObject msg=new JSONObject();
              msg.put("msg",name);
              return  msg;
          }
          else{
              JSONObject msg=new JSONObject();
              msg.put("msg",user.getuName());
              return  msg;
          }

    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> by_19/5/8
    @RequestMapping(value = "/user/validate/forget" )//注册时的邮箱验证
    @ResponseBody                             //uEmail邮箱
    @CrossOrigin
    public JSONObject forgrtPass(String uEmail) {
        if (uEmail!= null) {
                User user = service.findOne(uEmail);
                if (user == null) {
                    JSONObject msg = new JSONObject();
                    msg.put("msg", "此邮箱未注册此系统");
                    return msg;
                }
                String code = UUID.getCode();  //获取验证码
                try {
                    new Mail().run(uEmail, "智慧教室", code); //发送验证码
                    redisTemplate.opsForValue().set(uEmail, code); //验证码放到redis
                    redisTemplate.expire(uEmail, 60 * 10, TimeUnit.SECONDS);  //设置过期时间10分钟，防止内存溢出                                         // 设置过期时间
                    JSONObject msg = new JSONObject();
                    msg.put("msg", "发送成功");
                    return msg;
                } catch (Exception e) {
                    e.printStackTrace();
                    JSONObject msg = new JSONObject();
                    msg.put("msg", "发送失败");
                    return msg;
                }
            }
            JSONObject msg = new JSONObject();
            msg.put("msg", "发送失败");
            return msg;

        }
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8

}
