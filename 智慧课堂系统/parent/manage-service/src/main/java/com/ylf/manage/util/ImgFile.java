package com.ylf.manage.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ImgFile {
    public  static String save(MultipartFile img){
        try{
            String fileName=img.getOriginalFilename();
            int index=fileName.lastIndexOf(".");
            String changeFileName=UUID.getCode()+fileName.substring(index);
<<<<<<< HEAD
<<<<<<< HEAD
            String path="E:\\idea-workspace\\parent\\manage-web\\src\\main\\webapp\\img\\"+changeFileName;
            img.transferTo(new File(path));
            return "img/"+changeFileName;
        }catch (Exception e){
            e.printStackTrace();
            return "img/base.png";
=======
            String path="C:\\Users\\Administrator\\Desktop\\apache-tomcat-8.0.53\\webapps\\ROOT\\img\\"+changeFileName;
            img.transferTo(new File(path));
            return "http://47.102.195.147/img/"+changeFileName;
        }catch (Exception e){
            e.printStackTrace();
            return "http://47.102.195.147/img/base.png";
>>>>>>> zhkt-ok
=======
            String path="E:/idea-workspace/parent/manage-web/src/main/webapp/img/"+changeFileName;
            img.transferTo(new File(path));
            return "http://localhost:8080/img/"+changeFileName;
        }catch (Exception e){
            e.printStackTrace();
            return "http://localhost:8080/img/base.png";
>>>>>>> by_19/5/8
        }
    }
}
