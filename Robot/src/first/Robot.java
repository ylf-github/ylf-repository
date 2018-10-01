package first;

import java.awt.Image;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** * java实现爬虫 */
public class Robot {
	public static void main(String[] args) {
		URL url = null;
		URLConnection urlconn = null;
		BufferedReader br = null;
		PrintWriter pw = null;//
		// String regex = "//.+";
		String regex = "(https|http)://[\\w+\\.?/?]+\\.jpg";// url匹配规则
		Pattern p = Pattern.compile(regex);
		try {
			url = new URL("https://www.douban.com/photos/album/1660596367/?start=144");// 爬取的网址、这里爬取的是一个生物网站
			urlconn = url.openConnection();
			pw = new PrintWriter(new FileWriter("D:/SiteURL.txt"), true);// 将爬取到的链接放到D盘的SiteURL文件中
			br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
			String buf = null;
			byte[] bs = new byte[1024 * 2];
			int len,i=0;
			while ((buf = br.readLine()) != null) {
				Matcher buf_m = p.matcher(buf);
				while (buf_m.find()) {
					Random a=new Random();
					i=a.nextInt();
					System.out.println(i);
					pw.println(buf_m.group());
					URL uri=new URL(buf_m.group());
					URLConnection con=uri.openConnection();
					InputStream input=con.getInputStream();
					OutputStream os = new FileOutputStream("D:/PCTEST/"+String.valueOf(i)+".jpg");
					while ((len = input.read(bs)) != -1) {
						os.write(bs, 0, len);
					}
					os.close();
				}
			}
			System.out.println("爬取成功^_^");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw.close();
		}
	}
}