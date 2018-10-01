package controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.User;
import service.DateEditor;


@Controller
public class RegisterController {
	      
	       //在控制器初始化时注册属性编辑器
	       @InitBinder
	       public void initBinder(WebDataBinder binder){
	    	  
	    	   binder.registerCustomEditor(Date.class,new DateEditor());
	       }
	        @RequestMapping(value="/register")
            public String register(@ModelAttribute User user,Model model,HttpServletRequest request){
			    try {
					request.setCharacterEncoding("utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	model.addAttribute("user",user);
				System.out.println(user.getLoginname());
	        	return "success";
            }
}
