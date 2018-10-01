package robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.ClientProtocolException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Analys {
	public static  House result(String info) throws ClientProtocolException, IOException {
		House house=new House();
		//house = getHouseInfo(DomTree.DomTree(info));
		house = getHouseInfo(test.DoGet.getTree(info));
		return house;
	}

	private static House getHouseInfo(String domTree) {
		House a = new House();
		if(domTree.length()>0){
		try{
		Document document = Jsoup.parse(domTree);
		String houseType=new String();
		String blockType=new String();
		String blockAge=new String();
		String FAR=new String();
		String fee=new String();
		String pManage=new String();
		String company=new String();
		String houseName=new String();
		String src = document.select(".img-large").attr("src");
		a.setImgUrl(src);
		 houseType = document.select("div.house-description").get(0).child(0).child(1).html();
		 blockType = document.select("div.house-description").get(0).child(1).child(1).html();
		 blockAge = document.select("div.house-description").get(0).child(2).child(1).html();
		 FAR = document.select("div.house-description").get(0).child(3).child(1).html();
		a.setHouseType(houseType);
		a.setBlockType(blockType);
		a.setBlockAge(blockAge);
		a.setFAR(FAR);
		fee = document.select("div.house-property").get(0).child(0).child(1).html();
		a.setFee(fee);
		pManage=document.select("#content > div > div.basicinfo-content.clearfix > div.detail-content > div.house-property > dl:nth-child(2) > dd").html();
		a.setpManage(pManage);
		company=document.select("#content > div > div.basicinfo-content.clearfix > div.detail-content > div.house-property > dl:nth-child(3) > dd").html();	
		a.setCompany(company);
		houseName=document.select("#content > div > div.basicinfo-out > h3").html();
		a.setHouseName(houseName);
		// 提取图片url
		/*
		 * String regex="<img class=\"img-large\".*\" />"; Pattern
		 * imgPattern=Pattern.compile(regex); Matcher
		 * imgMatcher=imgPattern.matcher(domTree); while(imgMatcher.find()){
		 * String temp=imgMatcher.group(); int n=temp.lastIndexOf("=\""); String
		 * imgUrl=temp.substring(n+2,temp.length()-4);
		 * System.out.println(imgUrl); }
		 */
		if(a!=null){
			
		return a;}
		else
			return null;
		}catch(Exception e){
			System.out.println("error");
			return null;
		}
		}
           return null;
	}
	public static void main(String[] args) throws ClientProtocolException, IOException {

		String[] info=new String[]{"http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=6113ef772722ff0d8f77278f",
				       "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=bbd449c96b1041075abbbcbf",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=9990a6000a4c5e8b93114cd6",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=66124f14bdf5ed7f2806ce8e",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=1a061445b428d62d59bbbc13",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=6cf70f7002c9ba0ba1a93455",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=e0467043f761a925d5b74ef4",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=10a846d9d6315ffd08f5eb5c",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=bd024bbddc553e55cf06a458",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=7c24ac7d4077155102294f0d",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=574c175b03466cbff90cadc4",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=9d54e77266975a708733041b",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=bad46b8d6249e52d26e0a063",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=d32908320ba183527c29bdda",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=1cf8a32317a3f1cbc27da2bb",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=6a7196c536b497e351e5c5bf",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=05dd7d5f380a3f18ac080ff8",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=ad3dca52ee43ade0c7f02560",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=b3dde2a50f79520400ff2da3",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=a53a7b2daaecaaeb3a04b115",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=d4034eb373f7d4efc0364437",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=df1b7fdf49bae964ec74f8a5",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=34b07336306fa74c2fe67bd2",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=bf324402131598a9f4231032",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=b3a5bc1d15b6dcf1223bf2a2",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=cb950a3a498c9670bb17e785",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=d1086101ef78d8110c0e6bcd",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=dee9bf4db2d3899082a12e23",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=edf977d416ead495c9e33cc4",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=2d23736a91efae991894c6f5",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=b593ce20f7c773a1276e98e8",
		        "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=6537527b35e28084130daad2"
		};int p=0;
		for(p=0;p<32;p++){
				House o=new House();
				o=result(info[p]);
				House_dao d=new House_dao();
					try {
						d.add(o);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("error");;
					}
					System.out.println("这是第"+(p+1)+"条记录！");
			}
		}
	}
