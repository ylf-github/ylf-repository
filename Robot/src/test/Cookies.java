package test;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;

public class Cookies {
      
	public static void main(String[] args) {
	    CookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpClient = HttpClients.custom()
	             .setDefaultCookieStore(cookieStore)
	             .build();
	     try {
	          HttpPost post = new HttpPost("http://www.baiduc.com");
	          BasicClientCookie cookie = new BasicClientCookie("name", "123"); 
	          //cookie.setVersion(0);  
	        //  cookie.setDomain(".域名");   //设置范围 项目之间
	          cookie.setPath("/");  //应用内
	          cookieStore.addCookie(cookie);
	          httpClient.execute(post);//
	          List<Cookie> cookies = cookieStore.getCookies();
	          for (int i = 0; i < cookies.size(); i++) {
	              System.out.println("Local cookie: " + cookies.get(i).getValue());
	          }
	          if(post!=null)
	        	  post.releaseConnection();
	        } catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(httpClient!=null)
					httpClient.getConnectionManager().shutdown();
			}
		}

}
