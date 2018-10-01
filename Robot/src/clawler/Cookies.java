package clawler;

import java.util.List;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;

public class Cookies {
           public static void main(String[] args){
     
        	   CookieStore cookieStore=new BasicCookieStore();
        	   HttpPost post=new HttpPost("https://blog.csdn.net/z69183787/article/details/78629388");
        	   try{
        		   BasicClientCookie cookie=new BasicClientCookie("id", "123");
        		   cookie.setPath("/");
        		   cookieStore.addCookie(cookie);
        		   CloseableHttpClient httpClient=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        		   httpClient.execute(post);
        		   List<Cookie> list=cookieStore.getCookies();
        		   for(Cookie c:list){
        			   System.out.println(c);
        		   }
        	   }catch(Exception e){
        		   e.printStackTrace();
        		   System.out.println("error");
        	   }
           }
}
