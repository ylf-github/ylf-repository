package fangtianxia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetInfo {
	 
	          public static void main(String[] args) throws IOException{
	        	  getHouse();
	          }
	
             public static void getHouse() throws IOException{
                     File file=new File("F:/123/url.txt");
                     Scanner input=new Scanner(file);
                     int j=0;
                     while(input.hasNext()){
                    	 j++;
                    	 String url=new String();
                    	 url=input.nextLine();
                    	 String temp=new String();
                    	 temp="http://esf.xian.fang.com"+url;
                    	 House_fang house=new House_fang();
                    	 house=getinfo(GetUrl.getTree(temp));
                    	 Fang_dao dao=new Fang_dao();
                    	 dao.fang_add(house);
                    	 System.out.println("这是第"+j+"条记录!");
                     }
                     System.out.println("爬取完成！");
             }
             public static House_fang getinfo(String url){
            	 try{
				     Document document=Jsoup.parse(url);
				     House_fang house=new House_fang();
				     String houseType=new String();
				     String houseArea=new String();
				     String price=new String();
				     String houseOrientation=new String();
				     String blockAge=new String();
				     String floor=new String();
				     String decorate=new String();
				     String villageName=new String();
				     String address=new String();
				     String urll=new String();
				     String temp=new String();
				     String realAddress=new String();
				     houseType=document.select("body > div.wid1200.clearfix > div.tab-cont.clearfix > div.tab-cont-right > div:nth-child(2) > div.trl-item1.w146 > div.tt").html();
				     houseArea=document.select("body > div.wid1200.clearfix > div.tab-cont.clearfix > div.tab-cont-right > div:nth-child(2) > div.trl-item1.w182 > div.tt").html();
				     price=document.select("body > div.wid1200.clearfix > div.tab-cont.clearfix > div.tab-cont-right > div:nth-child(2) > div.trl-item1.w132 > div.tt").html();
				     houseOrientation=document.select("body > div.wid1200.clearfix > div.tab-cont.clearfix > div.tab-cont-right > div:nth-child(3) > div.trl-item1.w146 > div.tt").html();
				     blockAge=document.select("body > div.wid1200.clearfix > div.w1200.clearfix > div.zf_new_left.floatl > div.content-item.fydes-item > div.cont.clearfix > div:nth-child(1) > span.rcont").html();
				     floor=document.select("body > div.wid1200.clearfix > div.tab-cont.clearfix > div.tab-cont-right > div:nth-child(3) > div.trl-item1.w182 > div.tt").html();
				     decorate=document.select("body > div.wid1200.clearfix > div.tab-cont.clearfix > div.tab-cont-right > div:nth-child(3) > div.trl-item1.w132 > div.tt").html();
				     villageName=document.select("#agantesfxq_C03_05").html();
				     address=document.select("#agantesfxq_C03_07").html();
				     temp=document.select("#agantesfxq_C03_08").html();
				     realAddress=address.concat(" "+temp);
				     urll=document.select(".ls_cl").attr("src");
				     house.setAddress(realAddress);
				     house.setBlockAge(blockAge);
				     house.setDecorate(decorate);
				     house.setFloor(floor);
				     house.setHouseArea(houseArea);
				     house.setHouseOrientation(houseOrientation);
				     house.setHouseType(houseType);
				     house.setPrice(price);
				     house.setUrl(urll);
				     house.setVillageName(villageName);
				     return house;
            	 }catch(Exception e){
            		 System.out.println("解析异常!");
            		 return null;
            	 }
             }
}
