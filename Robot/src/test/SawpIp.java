package test;

import org.apache.http.HttpEntity;

import org.apache.http.HttpHost;

import org.apache.http.client.config.RequestConfig;

import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;

import org.apache.http.util.EntityUtils;

 

public class SawpIp {

 

	public static void main(String[] args)throws Exception {

		CloseableHttpClient httpClient=HttpClients.createDefault(); // 创建httpClient实例

		HttpGet httpGet=new HttpGet("https://www.taobao.com/"); // 创建httpget实例

		//HttpHost proxy=new HttpHost("177.101.139.208", 8080);

		//RequestConfig requestConfig=RequestConfig.custom().setProxy(proxy).build();

		//httpGet.setConfig(requestConfig);

		//httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
		httpGet=clawler.SawpIp.sawpGetIp(httpGet);
	
         try{
		    CloseableHttpResponse response=httpClient.execute(httpGet); // 执行http get请求
         
		    System.out.println(response);
			HttpEntity entity=response.getEntity(); // 获取返回实体

			System.out.println("网页内容："+EntityUtils.toString(entity, "utf-8")); // 获取网页内容
		    response.close(); // response关闭
		    httpClient.close(); // httpClient关闭
         }catch(Exception e){
        	 System.out.println("连接异常");
         }


		

		

	}

}
