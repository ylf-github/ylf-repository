package interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
	private static final String[] IGNORE_URL={
			"loginfrom","login","error"
	};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		boolean flag=false;
		
		String servletPath=request.getServletPath();
		//System.out.println(servletPath);
		for(String s:IGNORE_URL){
			if(servletPath.contains(s)){
				flag=true;
				break;
			}
		}
		if(!flag){
			/*HttpSession session=request.getSession();
			if((String)session.getAttribute("login")!=null)
				flag=true;
			else{
				 
				 request.getRequestDispatcher("error").forward(request, response);
				 flag=false;
			}	
				*/
			Cookie[] cookies=request.getCookies();
			if(cookies!=null){
		    for(Cookie cookie:cookies){
		    	if(cookie.getValue().equals("yes"))
		    	{	flag=true;
		    	     break;
		    	}
		    }
			}
			if(flag==false)
				request.getRequestDispatcher("error").forward(request, response);
		}
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
