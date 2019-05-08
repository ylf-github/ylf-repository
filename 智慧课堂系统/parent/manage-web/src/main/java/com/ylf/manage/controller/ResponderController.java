package com.ylf.manage.controller;
import com.ylf.manage.entity.User;
import com.ylf.manage.iservice.User_iserv;
import com.ylf.manage.util.UUID;
import net.sf.json.JSONObject;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

@Controller
public class ResponderController {
    @Autowired
    private CuratorFramework client;
    @Resource(name="redisTemplate")
    private RedisTemplate redisTemplate;
    @Autowired
    private User_iserv uService;

    @RequestMapping("/responder/mutex")    //学生抢答
    @ResponseBody                          //u_id用户id
<<<<<<< HEAD
<<<<<<< HEAD
    @CrossOrigin
    public JSONObject test(String uId){
        String path=(String) redisTemplate.opsForValue().get("id");
        if(path!=null) {
            try {

                client.create().forPath("/responder/" + path);
                User user = uService.findOne(uId);
                redisTemplate.opsForValue().set("user", user.getuName());
=======
=======
>>>>>>> by_19/5/8
    @CrossOrigin                           //c_id课程号
    public JSONObject test(String uId,String c_id){
        String path=(String) redisTemplate.opsForValue().get(c_id+"resp");
        if(path!=null) {
            try {
                client.create().forPath("/responder/" + path);
                User user = uService.findOne(uId);
                redisTemplate.opsForValue().set(c_id+"user", user.getuName());
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
                JSONObject msg = new JSONObject();
                msg.put("msg", "1");
                return msg;
             } catch (Exception e) {
                JSONObject msg=new JSONObject();
                msg.put("msg","抢答失败");
                return msg;
              }
            }
            else{
                JSONObject msg=new JSONObject();
                msg.put("msg","暂无抢答");
                return msg;
            }
    }


    @RequestMapping("/responder/add")    //发布抢答
    @ResponseBody
    @CrossOrigin
<<<<<<< HEAD
<<<<<<< HEAD
    public JSONObject addResponder(){
        redisTemplate.opsForValue().set("id",UUID.getUUID());
        redisTemplate.expire("id",2, TimeUnit.MINUTES);
=======
=======
>>>>>>> by_19/5/8
    public JSONObject addResponder(String c_id,String desc){ //c_id课程号
        redisTemplate.opsForValue().set(c_id+"desc",desc);
        redisTemplate.opsForValue().set(c_id+"resp",UUID.getUUID());
        redisTemplate.expire(c_id+"desc",3, TimeUnit.MINUTES);
        redisTemplate.expire(c_id+"resp",3, TimeUnit.MINUTES);
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
        JSONObject msg=new JSONObject();
        msg.put("msg","1");
        return msg;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @RequestMapping("/responder/look")
    @ResponseBody
    public JSONObject lookResponderUser(){
        String uName=(String) redisTemplate.opsForValue().get("user");
=======
=======
>>>>>>> by_19/5/8
    @RequestMapping("/responder/info")    //得到抢答信息
    @ResponseBody
    @CrossOrigin
    public JSONObject getResponderInfo(String c_id){ //c_id课程号
        String desc=(String) redisTemplate.opsForValue().get(c_id+"desc");
        JSONObject msg=new JSONObject();
        msg.put("msg",desc);
        return msg;
    }

    @RequestMapping("/responder/have")    //判断是否有抢答
    @ResponseBody
    @CrossOrigin
    public JSONObject haveResponder(String c_id){ //c_id课程号
        String desc=(String) redisTemplate.opsForValue().get(c_id+"resp");
        if(desc!=null){
            JSONObject msg=new JSONObject();
            msg.put("msg","1");
            return msg;
        }
         else{
            JSONObject msg=new JSONObject();
            msg.put("msg","0");
            return msg;
        }
    }

    @RequestMapping("/responder/look")
    @ResponseBody
    public JSONObject lookResponderUser(String c_id){       //c_id课程号
        String uName=(String) redisTemplate.opsForValue().get(c_id+"user");
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
        if(uName!=null){
            JSONObject msg=new JSONObject();
            msg.put("msg",uName);
            return msg;
        }
        else{
            JSONObject msg=new JSONObject();
<<<<<<< HEAD
<<<<<<< HEAD
            msg.put("msg","暂时无人应答");
=======
            msg.put("msg","0");
>>>>>>> zhkt-ok
=======
            msg.put("msg","0");
>>>>>>> by_19/5/8
            return msg;
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> by_19/5/8
    @RequestMapping("/responder/del")
    @ResponseBody                                 //老师获取到学生信息后删除学生信息
    public JSONObject delUser(String c_id){       //c_id课程号
        redisTemplate.delete(c_id+"user");
        JSONObject msg=new JSONObject();
        msg.put("msg","1");
        return msg;
    }

    @RequestMapping("/responder/delete")
    @ResponseBody                                 //删除抢答
    public JSONObject delResponder(String c_id){       //c_id课程号
        redisTemplate.delete(c_id+"resp");
        JSONObject msg=new JSONObject();
        msg.put("msg","1");
        return msg;
    }

<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8

}
