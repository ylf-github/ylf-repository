package com.ylf.manage.controller;

import com.ylf.manage.entity.Sign;
import com.ylf.manage.entity.User;
import com.ylf.manage.iservice.Sign_iserv;
import com.ylf.manage.util.UUID;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class SignController {
     @Autowired
     private RedisTemplate redisTemplate;
     @Autowired
     private Sign_iserv service;


     @RequestMapping("/sign/add")
     @ResponseBody
     @CrossOrigin
     public JSONObject sign(String c_id, String time, String desc,String mark){     //创建签到
         if(c_id!=null&&time!=null&&mark!=null){                                    //c_id课程id,time签到持续时间
             String content=(String) redisTemplate.opsForValue().get(c_id);         //mark现场签到码
             if(content!=null){  //说明这门课程还有签到未结束
                 JSONObject msg=new JSONObject();
                 msg.put("msg","请等待上一签到结束或结束上一签到");
                 return msg;
             }
             Date date=new Date();
             String createTime=date.toLocaleString();
             String s_id= UUID.getUUID();
             long realTime=Integer.parseInt(time);
             redisTemplate.opsForValue().set("mark",mark);
             redisTemplate.opsForValue().set(c_id,s_id);
             redisTemplate.expire("mark",realTime, TimeUnit.MINUTES);
             redisTemplate.expire(c_id,realTime, TimeUnit.MINUTES);
             Sign sign=new Sign();
             sign.setsId(s_id);
             sign.setcId(c_id);
             sign.setDes(desc);
             sign.setTime(createTime);
             int n=service.add(sign);
             if(n>0){
                 JSONObject msg=new JSONObject();
                 msg.put("msg","1");
                 return msg;
             }
             else{
                 JSONObject msg=new JSONObject();
                 msg.put("msg","签到发布失败");
                 return msg;
             }
         }
         JSONObject msg=new JSONObject();
         msg.put("msg","签到发布失败");
         return msg;
     }

     @RequestMapping("/sign/end")
     @ResponseBody
     @CrossOrigin
     public JSONObject endSign(String c_id){          //结束签到
         if(c_id!=null){                              //c_id课程id
             redisTemplate.delete(c_id);
             JSONObject msg=new JSONObject();
             msg.put("msg","1");
             return msg;
         }
         JSONObject msg=new JSONObject();
         msg.put("msg","签到结束失败");
         return msg;
     }

     @RequestMapping("/sign/find")
     @ResponseBody
     @CrossOrigin
     public List<Sign> getCourseSignInfo(String c_id){   //查找某课程所有签到记录
         return service.getCourseSignInfo(c_id);         //c_id课程id
     }

     @RequestMapping("/sign/is/signer")
     @ResponseBody
     @CrossOrigin
     public List<User> findAllIsSigner(String s_id){     //返回已签到的用户信息
         return service.findAllIsSigner(s_id);           //s_id签到id
     }

    @RequestMapping("/sign/not/signer")
    @ResponseBody
    @CrossOrigin
    public List<User> findAllNotSigner(String s_id){     //返回未签到的用户信息
        return service.findAllNotSigner(s_id) ;          //s_id签到id
    }

    @RequestMapping("/sign/del")
    @ResponseBody
    @CrossOrigin
    public JSONObject delSign(String s_id,String c_id){   //删除签到
         if(s_id!=null&&c_id!=null){                  //s_id签到id
             int n=service.del(s_id);                 //c_id课程id
             if(n>0){
                 redisTemplate.delete(c_id);
                 JSONObject msg=new JSONObject();
                 msg.put("msg","1");
                 return msg;
             }
             else{
                 JSONObject msg=new JSONObject();
                 msg.put("msg","删除签到失败");
                 return msg;
             }
         }
        JSONObject msg=new JSONObject();
        msg.put("msg","删除签到失败");
        return msg;
    }
}
