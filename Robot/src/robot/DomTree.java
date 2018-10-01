package robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class DomTree {
             public static String DomTree(String url){
            	 URL temp=null;
            	 URLConnection conn=null;
            	 BufferedReader br=null;
            	 InputStream in = null;
            	 StringBuffer stringbuffer=null;
				 try{
					 temp=new URL(url);
					 conn=temp.openConnection();
					 conn.setConnectTimeout(5000);
					 conn.setReadTimeout(5000);
					 in=conn.getInputStream();
					 br=new BufferedReader(new InputStreamReader(in));
					 stringbuffer=new StringBuffer();
					 String line=null;
					 while((line=br.readLine())!=null){
						 stringbuffer.append(line);
					 }
				 }catch(Exception e){
					 e.printStackTrace();
					 return null;
				 }finally{
					 try {
						in.close();
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
				 }
				return stringbuffer.toString();
             }
}