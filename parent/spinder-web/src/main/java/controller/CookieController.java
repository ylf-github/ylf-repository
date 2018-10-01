package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
             @RequestMapping(value="/cookietest")
             public void cookietest(@RequestHeader("User-Agent") String userAgent,
            		    @RequestHeader(value="Accept") String[] accepts,
            		    @CookieValue(value="age",required=false,defaultValue="") String cookie1,
            		    @CookieValue(value="nm",required=false,defaultValue="") String cookie2
            		 ){
            	  System.out.println(userAgent);
            	  for(String accept:accepts){
            		  System.out.println(accept);
            	  }
            	  System.out.println(cookie1);
            	  System.out.println(cookie2);
             }
}
