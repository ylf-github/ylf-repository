package com.ylf.manage.controller;

<<<<<<< HEAD
<<<<<<< HEAD
import com.ylf.manage.entity.Signer;
=======
=======
>>>>>>> by_19/5/8
import com.ylf.manage.entity.Sger;
import com.ylf.manage.entity.Sign;
import com.ylf.manage.entity.Signer;
import com.ylf.manage.iservice.Sign_iserv;
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
import com.ylf.manage.iservice.Signer_iserv;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.DatabaseMetaData;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> zhkt-ok
=======
import java.util.ArrayList;
>>>>>>> by_19/5/8
import java.util.Date;
import java.util.List;

@Controller
public class SignerController {
       @Autowired
       private Signer_iserv service;
       @Autowired
       private RedisTemplate redisTemplate;
<<<<<<< HEAD
<<<<<<< HEAD
=======
       @Autowired
       private Sign_iserv sservice;
>>>>>>> zhkt-ok
=======
       @Autowired
       private Sign_iserv sservice;
>>>>>>> by_19/5/8

       @RequestMapping("/signer/update")
       @ResponseBody
       @CrossOrigin
       public JSONObject updateSigner(String c_id, String u_email,String mark){          //用户签到,c_id课程id
           String s_id=(String)redisTemplate.opsForValue().get(c_id);                    //mark签到码,u_email用户id
           String code=(String)redisTemplate.opsForValue().get("mark");
           if(code==null){
               JSONObject msg=new JSONObject();
               msg.put("msg","签到失败");
               return msg;
           }
           if(!code.equals(mark)){
               JSONObject msg=new JSONObject();
               msg.put("msg","签到码不正确");
               return msg;
           }
           Date date=new Date();
           String time=date.toLocaleString();
           if (s_id!=null){
               Signer signer=new Signer();
               signer.setuEmail(u_email);
               signer.setsTime(time);
               signer.setsId(s_id);
               signer.setcId(c_id);
               int n=service.upd(signer);
               if(n>0){
                   JSONObject msg=new JSONObject();
                   msg.put("msg","1");
                   return msg;
               }
               else{
                   JSONObject msg=new JSONObject();
                   msg.put("msg","签到失败");
                   return msg;
               }
           }
           JSONObject msg=new JSONObject();
           msg.put("msg","签到失败");
           return msg;
       }

       @RequestMapping("/signer/judge")
       @ResponseBody
       @CrossOrigin
       public JSONObject isSign(String c_id){        //判断是否可以签到，c_id课程id
           String result=(String)redisTemplate.opsForValue().get(c_id);
           if(result!=null){
               JSONObject msg=new JSONObject();
               msg.put("msg","1");
               return msg;
           }
           else{
               JSONObject msg=new JSONObject();
               msg.put("msg","暂无签到");
               return msg;
           }
       }

       @RequestMapping("/signer/info")           //返回某用户某课程的全部签到信息
       @ResponseBody
       @CrossOrigin                              //c_id课程id，u_email用户id
<<<<<<< HEAD
<<<<<<< HEAD
       public List<Signer> signerInfo(String c_id,String u_email){
=======
       public List<Sger> signerInfo(String c_id,String u_email){
>>>>>>> zhkt-ok
=======
       public List<Sger> signerInfo(String c_id,String u_email){
>>>>>>> by_19/5/8
            if(c_id!=null&&u_email!=null){
                Signer signer=new Signer();
                signer.setcId(c_id);
                signer.setuEmail(u_email);
<<<<<<< HEAD
<<<<<<< HEAD
                return service.signInfo(signer);
=======
=======
>>>>>>> by_19/5/8
                List<Signer> list= service.signInfo(signer);
                List<Sger> sgers=new ArrayList<>();
                List<Sign> signlist=new ArrayList<>();
                if(list!=null){
                    for(int i=0;i<list.size();i++){
                        Sign sign=sservice.getOne(list.get(i).getsId());
                        Sger sger=new Sger();
                        sger.setDes(sign.getDes());
                        sger.setSign(list.get(i).getsType());
                        sger.setTime(list.get(i).getCreateTime());
                        sgers.add(sger);
                    }
                }
               return sgers;
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
            }
            return null;
       }
}
