package fangtianxia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetUrl {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		int o = 1;
		while (o < 11) {
			String url = "http://esf.xian.fang.com/house/i3" + o + "/";
			String a = getTree(url);
			urlToFile(a);
			System.out.println("正在爬取第"+o+"个网页url");
			 o++;
		}
        System.out.println("URL爬取完成！");
	}

	public static void urlToFile(String Tree) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		File file = new File("F:/123/url.txt");
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		String regex = "/chushou.*htm";
		Pattern p = Pattern.compile(regex);
		Matcher buf_m = p.matcher(Tree);
		while (buf_m.find()) {
			if (!list.contains(buf_m.group())) {
				list.add(buf_m.group());
			}
		}
		for (int i = 0; i < list.size(); i++)
			pw.println(list.get(i));
		pw.close();
	}

	public static String getTree(String url) throws IOException {
		// 创建httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建GET请求
		HttpGet httppost = new HttpGet(url);
		// 创建响应
		CloseableHttpResponse response = null;
		// 执行响应
		try{
		response = httpclient.execute(httppost);
		}catch(Exception e){
			return null;
		}
		// 判断返回状态码
		if (response.getStatusLine().getStatusCode() == 200) {
			try {
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				return content;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("error");
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error");
				return null;
			}finally {
				  if (httpclient != null && httppost != null){
				        
					    // 释放连接资源
					    httppost.releaseConnection();
					    // 关闭Socket连接
					    httpclient.getConnectionManager().shutdown();
					  }
					}
		} else {
			System.out.println("服务器拒绝请求！");
			return null;
		}
		
	}
	
}
