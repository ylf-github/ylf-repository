package com.example.boot.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.example.boot.redis.service.RedisListener;

@Configuration
public class RedisConfig {
      @Bean
      MessageListenerAdapter listenerAdapter() {
    	  return new MessageListenerAdapter(new RedisListener());
      }
      @Bean
      RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
    		 MessageListenerAdapter listenerAdapter) {
    	  RedisMessageListenerContainer container=new RedisMessageListenerContainer();
    	  container.setConnectionFactory(connectionFactory);
    	  container.addMessageListener(listenerAdapter, new PatternTopic("new"));
    	  return container;
      }
}
