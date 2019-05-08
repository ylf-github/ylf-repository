package com.ylf.one.controller;
import java.util.concurrent.TimeUnit;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/*采用Curator实现分布式锁*/
@Controller
public class Distributed_mutex {
	    Log log=LogFactory.getLog(Distributed_mutex.class);
	    String path="/order/mutex";
        @Autowired
        private CuratorFramework client;
        @RequestMapping("/order/mutex")
        @ResponseBody
        public void order() {
        	log.info("try to do job for path "+path);
        	try {
        		InterProcessMutex lock=new InterProcessMutex(client,path);
        		if(lock.acquire(2, TimeUnit.HOURS)) {    //获取锁并设置过期时间，避免死锁
        			try {
        				//假设业务需要5s
        				Thread.sleep(1000*5);
        				//即使获得了分布式锁，在实际业务处理中为了准确也应检查数据是否已经被处理
        				log.info("do job for path "+path+" is OK!");
        			}finally {
        				lock.release();
        			}
        		}
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        
}
