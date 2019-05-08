package com.ylf.manage.controller;

<<<<<<< HEAD
<<<<<<< HEAD
import com.ylf.manage.entity.Resource;
import com.ylf.manage.entity.Score;
=======
=======
>>>>>>> by_19/5/8
import com.ylf.manage.entity.RepScore;
import com.ylf.manage.entity.Resource;
import com.ylf.manage.entity.Score;
import com.ylf.manage.iservice.RepScore_iserv;
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
import com.ylf.manage.iservice.Resource_iserv;
import com.ylf.manage.iservice.Score_iserv;
import com.ylf.manage.util.ResourceFile;
import com.ylf.manage.util.UUID;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
public class ResourceController {
    @Autowired
    private Resource_iserv service;
    @Autowired
    private Score_iserv sService;
<<<<<<< HEAD
<<<<<<< HEAD
=======
    @Autowired
    private RepScore_iserv rpservice;
>>>>>>> zhkt-ok
=======
    @Autowired
    private RepScore_iserv rpservice;
>>>>>>> by_19/5/8

    //老师部分

    @RequestMapping("/resource/bin/add")   //发布二进制资源
    @ResponseBody//rfile资源文件 c_id课程号 resource包括rName资源名称，rScore经验值
    @CrossOrigin
    public JSONObject addBinResource(Resource resource, MultipartFile rFile, String c_id){
        Date date=new Date();
        String time=date.toLocaleString();
        if(resource!=null&&rFile!=null&&c_id!=null){
              String url= ResourceFile.save(rFile);
              if(url==null){
                  JSONObject msg=new JSONObject();
                  msg.put("msg","发布失败");
                  return msg;
              }

              else{
                  resource.setcId(c_id);
                  resource.setrCreatetime(time);
                  resource.setrId(UUID.getUUID());
                  resource.setrUrl(url);
                  int n=service.add(resource);
                  if(n>0){
                      JSONObject msg=new JSONObject();
                      msg.put("msg","1");
                      return msg;
                  }
                  else{
                      JSONObject msg=new JSONObject();
                      msg.put("msg","发布失败");
                      return msg;
                  }
              }
        }
        JSONObject msg=new JSONObject();
        msg.put("msg","发布失败");
        return msg;
    }

    @RequestMapping("/resource/url/add")       //发布网络资源
    @ResponseBody                              //resource包括rName资源名称，rUrl网络地址，rScore经验值
    @CrossOrigin
    public JSONObject addUrlResource(Resource resource,String c_id){
        Date date=new Date();
        String time=date.toLocaleString();
        if(resource!=null&&c_id!=null){
                resource.setrId(UUID.getUUID());
                resource.setrCreatetime(time);
                resource.setcId(c_id);
                int n=service.add(resource);
                if(n>0){
                    JSONObject msg=new JSONObject();
                    msg.put("msg","1");
                    return msg;
                }
                else{
                    JSONObject msg=new JSONObject();
                    msg.put("msg","发布失败");
                    return msg;
                }
        }
        JSONObject msg=new JSONObject();
        msg.put("msg","发布失败");
        return msg;
    }

    @RequestMapping("/resource/del")      //删除资源
    @ResponseBody                         //r_id资源主键
    @CrossOrigin
    public JSONObject delResource(String r_id){
        if(r_id!=null){
            int n=service.del(r_id);
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

    @RequestMapping("/resource/course/list")        //返回某课程的全部资源
    @ResponseBody                                   //c_id课程号
    @CrossOrigin
    public List<Resource> getCourseResource(String c_id){
        if(c_id!=null){
            return service.findAllCourseResource(c_id);
        }
        return null;
    }

    //学生部分
    @RequestMapping("/resource/download")         //学生下载资源
    @ResponseBody                                 //num经验值，c_id课程号
    @CrossOrigin                                  //url资源地址.u_id用户id
<<<<<<< HEAD
<<<<<<< HEAD
    public ResponseEntity<byte[]> getFile (String url, String num, String c_id, String u_id) throws Exception{
=======
    public ResponseEntity<byte[]> getFile (String url, String num, String c_id, String u_id,String r_id) throws Exception{
>>>>>>> zhkt-ok
=======
    public ResponseEntity<byte[]> getFile (String url, String num, String c_id, String u_id,String r_id) throws Exception{
>>>>>>> by_19/5/8
        Integer readlNum=Integer.parseInt(num);
        if(url.contains("www")||url.contains("http")){
            Score score=new Score();
            score.setcId(c_id);
            score.setuEmail(u_id);
            score.setNum(readlNum);
<<<<<<< HEAD
<<<<<<< HEAD
            sService.upd(score);
=======
=======
>>>>>>> by_19/5/8
            RepScore repScore=new RepScore();
            repScore.setrId(r_id);
            repScore.setuEmail(u_id);
            if(rpservice.getOne(repScore)==null){
                rpservice.add(repScore);
                sService.upd(score);
            }
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
            return null;
        }
        else{
            Score score=new Score();
            score.setcId(c_id);
            score.setuEmail(u_id);
            score.setNum(readlNum);
<<<<<<< HEAD
<<<<<<< HEAD
            sService.upd(score);
=======
=======
>>>>>>> by_19/5/8
            RepScore repScore=new RepScore();
            repScore.setrId(r_id);
            repScore.setuEmail(u_id);
            if(rpservice.getOne(repScore)==null){
                rpservice.add(repScore);
                sService.upd(score);
            }
<<<<<<< HEAD
>>>>>>> zhkt-ok
=======
>>>>>>> by_19/5/8
            File file=new File(url);
            HttpHeaders headers=new HttpHeaders();
            //下载显示的文件名，解决中文乱码问题
            String downloadFileName=new String(url.getBytes("UTF-8"),"iso-8859-1");
            //告知浏览器以下载方式打开文件
            headers.setContentDispositionFormData("attachment",downloadFileName);
            //设置二进制数据流
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
        }
    }

}
