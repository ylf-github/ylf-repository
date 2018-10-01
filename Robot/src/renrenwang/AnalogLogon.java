package renrenwang;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class AnalogLogon {
           public static void main(String[] args){
        	   //创建httpclient对象
        	   CloseableHttpClient httpclient=HttpClients.createDefault();
        	   //目标网址
        	   String url="http://www.renren.com/PLogin.do";
        	   //创建post请求
        	   HttpPost post=new HttpPost(url);
        	   //以POST方式请求，携带账号和密码参数
        	   List<NameValuePair> list=new ArrayList<>();
        	   list.add(new BasicNameValuePair("email","17602921826"));
        	   list.add(new BasicNameValuePair("password","wangjita123."));
        	   try{
        		   post.setEntity(new UrlEncodedFormEntity(list));
        		   CloseableHttpResponse response=httpclient.execute(post);
        		   //得知跳转的哪一个网页
        		   System.out.println(response);
        		   //获取请求头
        		   Header header=response.getFirstHeader("Location");
        		   //以Get请求重定向网址
        		   HttpGet get=new HttpGet(header.getValue());
        		   //创建响应处理器
        		  // ResponseHandler<String> responseHandler=new BasicResponseHandler();
        		   //String content=httpclient.execute(get,responseHandler);
        		   //执行请求
        		   CloseableHttpResponse res=null;
        		   res=httpclient.execute(get);
        		   String content = EntityUtils.toString(res.getEntity(), "UTF-8");
        		   System.out.println(content);
        		   if(get!=null)
        			   get.releaseConnection();
        	   }catch(Exception e){
        		   System.out.println("error");
        		   return;
        	   }finally{
        		   if(httpclient!=null)
        			   httpclient.getConnectionManager().shutdown();
        		   if(post!=null)
        			   post.releaseConnection();
        
        	   }
           }
}
