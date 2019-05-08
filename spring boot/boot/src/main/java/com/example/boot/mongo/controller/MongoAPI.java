package com.example.boot.mongo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.mongo.entity.Baike;

@RestController
public class MongoAPI {
	   @Autowired
	   private MongoTemplate client;
        //增
	   @RequestMapping("/add")
	   public String add(Baike baike) {
		   baike.setDate(new Date());
		   client.insert(baike);
		   return "ok";
	   }
	   //ID查
	   @RequestMapping("/get")
	   public Baike get(String id) {
		  Baike temp= client.findById(id, Baike.class);
		   return temp;
	   }
	   //改
	   @RequestMapping("/upd")
	   public String upd(String id) {
		   Criteria criteria= Criteria.where("id").is(id);
		   Update update=new Update();
		   update.set("desc", "NoSql数据库");
		   client.updateFirst(new Query(criteria), update, Baike.class);
		   return "ok";
	   }
	   
	   //删
	   @RequestMapping("/del")
	   public String del(String id) {
		   Baike baike=new Baike();
		   baike.setId(id);
		   client.remove(baike);
		   return "ok";
	   }
	   
	   //标准查询
	   @RequestMapping("/cri")
	   public List<Baike> cri(Integer cri) {
		   System.out.println(cri);
		   Criteria criteria=Criteria.where("comment.good").gt(cri);
		   List<Baike> list=client.find(new Query(criteria), Baike.class);
		   return list;
	   }
	   
	   //分页查询
	   @RequestMapping("page/{page}")
	   public List<Baike> page(@PathVariable Integer page){
		   Query query=new Query(new Criteria());
		   query.skip((page-1)*5).limit(5);
		   List<Baike> list=client.find(query, Baike.class,"baike");
		   return list;
	   }
}
