package com.example.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringRedisController {

	protected static Logger logger = LoggerFactory.getLogger(StringRedisController.class);
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Resource(name = "stringRedisTemplate")
	ValueOperations<String, String> valOpsStr;
	
	
	@RequestMapping("get/{key}")
	public String getKey(@PathVariable("key") String key){
		logger.debug("访问get:key={}",key);
		return valOpsStr.get(key);
	}
	
	@RequestMapping("set/{key}/{value}")
	public String setKeyAndValue(@PathVariable("key") String key,@PathVariable("value") String value){
		logger.debug("访问set:key={},value={}",key,value);
		valOpsStr.set(key,value);
		return "Set OK";
	}
}
