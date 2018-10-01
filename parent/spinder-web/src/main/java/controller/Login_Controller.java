package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Login;
import iservice.Login_iservice;
import net.sf.json.JSONObject;

@Controller
public class Login_Controller {
	
	@Autowired
	private Login_iservice service;
	
           @RequestMapping(value="/login")
           @ResponseBody
           public JSONObject login(@RequestBody Login login,HttpServletRequest request
        		   ,HttpServletResponse response
        		   ){
        	  // HttpSession session=request.getSession();
        	  // session.setAttribute("login", "yes");
        	   Cookie cookie=new Cookie("login","yes");
        	   response.addCookie(cookie);
        	   JSONObject a=new JSONObject();
			  int n=service.addTo(login);
			  if(n>0)
			  {
				  a.put("msg", "ok");
				  return a;
			  }
			  else
			  {
				  a.put("msg", "no-ok");
				  return a;
			  }
        	   
           }
           
           @RequestMapping(value="/{from}")
           public String from(@PathVariable String from){
        	   return from;
           }
}
