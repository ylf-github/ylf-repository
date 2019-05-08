package com.ylf.manage.controller;

import com.ylf.manage.entity.Task;
import com.ylf.manage.iservice.Task_iserv;
import com.ylf.manage.util.UUID;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private Task_iserv service;

    @RequestMapping("/task/add")
    @ResponseBody
    @CrossOrigin
    public JSONObject addTask(Task task){   //添加资源
        if(task!=null){
            task.settId(UUID.getUUID());
            String date=new Date().toLocaleString();
            task.settTime(date);
            int n=service.add(task);
            if(n>0){
                JSONObject msg=new JSONObject();
                msg.put("msg","1");
                return msg;
            }
            else {
                JSONObject msg=new JSONObject();
                msg.put("msg","添加失败");
                return msg;
            }
        }
        JSONObject msg=new JSONObject();
        msg.put("msg","添加失败");
        return msg;
    }

    @RequestMapping("/task/del")
    @ResponseBody
    @CrossOrigin
    public JSONObject delTask(String id){   //删除资源
        if(id!=null){
            int n=service.del(id);
            if(n>0){
                JSONObject msg=new JSONObject();
                msg.put("msg","1");
                return msg;
            }
            else{
                JSONObject msg=new JSONObject();
                msg.put("msg","删除失败");
                return msg;
            }
        }
        JSONObject msg=new JSONObject();
        msg.put("msg","删除失败");
        return msg;
    }

    @RequestMapping("/task/list")          //返回某课程全部任务
    @ResponseBody
    @CrossOrigin
    public List<Task> getAll(String cId){
        return service.findAll(cId);
    }

    @RequestMapping("/task/one")          //返回单个任务
    @ResponseBody
    @CrossOrigin
    public Task getOne(String tId){
        return service.getOne(tId);
    }

}
