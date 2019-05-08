package com.example.boot.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisAPI {
	  @Autowired
	  @Qualifier("stringRedisTemplate")
      private RedisTemplate client;
	  
	  @RequestMapping("/usually")
	  public String usu() {
		  client.opsForValue().set("hello", "world");
		  String result=(String) client.opsForValue().get("hello");
		  return result;
	  }
	  
	  @RequestMapping("/list")  
	  public List list() {
		BoundListOperations opt=client.boundListOps("data");
		opt.leftPush("data3");
		opt.rightPush("data4");
		  return client.opsForList().range("data", 0, 9);
	  }
	  
	  @RequestMapping("/pub")
	  public String pub() {
		  client.convertAndSend("new", "Hello,World!");
		  return "ok";
	  }
	  
}
