package clawler;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public class SawpIp {
	public static HttpGet sawpGetIp(HttpGet get) {
		// IP和端口可以遍历替换
		HttpHost proxy = new HttpHost("177.101.139.208", 8080);
		// 配置IP
		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
		//设置超时连接
		config=RequestConfig.custom().setConnectTimeout(2000).build();
		// 设置配置
		get.setConfig(config);
		// 设置用户标识符User_Agent
		get.setHeader("User_Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
		return get;
	}

	public static HttpPost sawpPostIp(HttpPost post) {
		// IP和端口可在IP池中遍历
		HttpHost proxy = new HttpHost("177.101.139.208", 8080);
		// 配置IP
		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
		//设置超时连接
		config=RequestConfig.custom().setConnectTimeout(2000).build();
		// 设置配置
		post.setConfig(config);
		// 设置用户标识符User_Agent
		post.setHeader("User_Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
		return post;
	}
}
