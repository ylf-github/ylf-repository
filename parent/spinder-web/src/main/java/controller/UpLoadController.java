package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UpLoadController {
      @RequestMapping(value="/upload",method=RequestMethod.POST)
      public String upload(HttpServletRequest request,
    		  @RequestParam("description") String description,
    		  @RequestParam("file") MultipartFile file
    		  ) throws IllegalStateException, IOException{
		   System.out.println(description);
    	   if(!file.isEmpty()){
    		   /* 项目发布的实际路径，这里太麻烦我们选用自定义简单路径
    		    String path=request.getServletContext().getRealPath("/images/");
    		   */
    		   String path="F:/123/test/";
    		   //上传文件名
    		   String filename=file.getOriginalFilename();
    		   File filepath=new File(path,filename);
    		   //判断路径是否存在，如果不存在就创建一个
    		   if(!filepath.exists())
    			   filepath.getParentFile().mkdirs();
    		   file.transferTo(new File(path+File.separator+filename));
    		   return "welcome";
    	   }
    	   else
    		   return "error";
    	  
      }
      
}
