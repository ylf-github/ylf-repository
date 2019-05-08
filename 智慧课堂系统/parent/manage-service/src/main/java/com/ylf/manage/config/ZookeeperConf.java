package com.ylf.manage.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZookeeperConf {
    @Bean
    public CuratorFramework getCuratorFramework(){
        CuratorFramework client=CuratorFrameworkFactory.builder().build();
        return  client;
    }
}
