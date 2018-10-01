package test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DoGet {
	// 创建Httpclient对象
	public static String getTree(String url) throws ClientProtocolException, IOException{
	CloseableHttpClient httpclient = HttpClients.createDefault();
	// 创建http GET请求
	HttpGet httpGet = new HttpGet(url);
	//创建响应
	CloseableHttpResponse response = null;
	// 执行请求
	response = httpclient.execute(httpGet);
	// 判断返回状态是否为200
	if (response.getStatusLine().getStatusCode() == 200) {
	      //读取响应内容
	      String content =EntityUtils.toString(response.getEntity(), "UTF-8");
	    //  System.out.println("内容长度：" + content.length());
	    //  System.out.println(content);
	      return content;
	      //将内容写到文件中      
	     //FileUtils.writeStringToFile(new File("C:\\baidu.html"), content);
	 }
	else
		return null;
	}
}

