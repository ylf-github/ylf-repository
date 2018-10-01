package test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SimpleClient {  
	  
    public static void main(String[] args) throws Exception {  
  
        // 创建Httpclient对象  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
  
        // 创建http POST请求  
        HttpPost httpPost = new HttpPost("https://www.baidu.com/");  
  
        CloseableHttpResponse response = null;  
        try {  
            // 执行请求  
            response = httpclient.execute(httpPost);  
            // 判断返回状态是否为200  
            if (response.getStatusLine().getStatusCode() == 200) {  
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");  
                System.out.println(content);  
            }
            else{
            	System.out.println("ook");
            }
        } finally {  
            if (response != null) {  
                response.close();  
            }  
            httpclient.close();  
        }  
  
    }  
  
} 