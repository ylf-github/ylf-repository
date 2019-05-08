package com.ylf.one.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceInstanceBuilder;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceDiscoveryController {
	@Autowired
	private CuratorFramework client;

	@RequestMapping("/rservice")
	@ResponseBody
	public String registerService() throws Exception {
		// 构造一个服务
		ServiceInstanceBuilder<Map> service = ServiceInstance.builder();
		service.address("192.168.1.100");
		service.port(9000);
		service.name("test");
		Map config = new HashMap();
		config.put("url", "/api/v3/book");
		service.payload(config);
		ServiceInstance<Map> instance = service.build();
		ServiceDiscovery<Map> serviceDiscovery = ServiceDiscoveryBuilder.builder(Map.class).client(client)
				.serializer(new JsonInstanceSerializer<Map>(Map.class)).basePath("/service").build();
		serviceDiscovery.registerService(instance);
		serviceDiscovery.start();
		return "ok";
	}
     @RequestMapping("/getservice")
     @ResponseBody
	public ServiceInstance<Map> findService() throws Exception {
		ServiceDiscovery<Map> serviceDiscovery = ServiceDiscoveryBuilder.builder(Map.class).client(client)
				.serializer(new JsonInstanceSerializer<Map>(Map.class)).basePath("/service").build();
		serviceDiscovery.start();
		//取得当前所有服务
		Collection<ServiceInstance<Map>> all=serviceDiscovery.queryForInstances("test");
		if(all.size()==0) {
			return null;
		}
		else {
			//取得第一个服务
			ServiceInstance<Map> service=new ArrayList<ServiceInstance<Map>>(all).get(0);
			//在实际应用中可以随机选择一个服务并保存起来供客户端获取信息，或者采用轮询机制
			System.out.println(service.getAddress());
			System.out.println(service.getPayload());
			return service;
		}
	}

}
