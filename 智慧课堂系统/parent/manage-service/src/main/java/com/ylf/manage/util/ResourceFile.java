package com.ylf.manage.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class ResourceFile {
    public static String save(MultipartFile file){
        try{
            String fileName=file.getOriginalFilename();
            int index=fileName.lastIndexOf(".");
            String changeFileName=UUID.getCode()+fileName.substring(index);
<<<<<<< HEAD
<<<<<<< HEAD
            String path="E:\\idea-workspace\\parent\\manage-web\\src\\main\\resources\\resource\\"+changeFileName;
=======
            String path="C:/Users/Administrator/Desktop/apache-tomcat-8.0.53/webapps/ROOT/resource/"+changeFileName;
>>>>>>> zhkt-ok
=======
            String path="E:/idea-workspace/parent/manage-web/src/main/resources/resource/"+changeFileName;
>>>>>>> by_19/5/8
            file.transferTo(new File(path));
            return path;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
