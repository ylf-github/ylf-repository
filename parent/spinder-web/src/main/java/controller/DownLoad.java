package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownLoad {
        @RequestMapping(value="/download")
        public ResponseEntity<byte[]> download() throws IOException{
			File file=new File("F:/123/test/20.jpg");
        	HttpHeaders headers=new HttpHeaders();
        	//下载显示文件名，解决中文名称乱码问题
        	String downLoadFileName=new String("20.jpg".getBytes("UTF-8"),"ISO-8859-1");
        	//通知浏览器以attachment(下载方式)打开图片
        	headers.setContentDispositionFormData("attachment", downLoadFileName);
        	//application/octet-stream：二进制流数据(最常见的文件下载)
        	headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        	//201 HttpStatus.CREATED
        	return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.OK);
        	
        }
}
