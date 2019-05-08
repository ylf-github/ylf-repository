package com.example.boot.redis.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisListener implements MessageListener{

	@Override
	public void onMessage(Message message, byte[] pattern) {
		byte[] channal=message.getChannel();
		byte[] bs=message.getBody();
		try {
			String content=new String(bs,"UTF-8");
			String p=new String(channal,"UTF-8");
			System.out.println("get "+content+" from "+p);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
          
}
