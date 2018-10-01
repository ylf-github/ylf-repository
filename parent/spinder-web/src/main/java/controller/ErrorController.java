package controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@RequestMapping("error")
public class ErrorController {
	private static final String BASE_DIR = "error/";
	@RequestMapping("404")
	public String handle2(HttpServletRequest request){
		return BASE_DIR + "404";
	}
	@RequestMapping("500")
	public String handle3(HttpServletRequest request){
		return BASE_DIR + "500";
	}
}

