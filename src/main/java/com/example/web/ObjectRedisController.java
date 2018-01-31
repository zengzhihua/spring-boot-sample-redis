package com.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Person;
import com.example.domain.PersonDao;

@RestController
public class ObjectRedisController {

	protected static Logger logger=LoggerFactory.getLogger(ObjectRedisController.class);
	
	@Autowired
	PersonDao personDao;
	
	@RequestMapping("/setPerson")
	public void set(String id,String name,Integer age){
		logger.debug("访问setPerson:id={},name={},age={}",id,name,age);
		Person person=new Person(id,name,age);
		personDao.save(person);
	}
	
	@RequestMapping("/getPerson/{id}")
	public Person getPerson(@PathVariable("id") String id){
		return personDao.getPerson(id);
	}
	
}