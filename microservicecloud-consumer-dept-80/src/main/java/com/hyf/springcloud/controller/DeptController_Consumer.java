package com.hyf.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hyf.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {
	
//private static final String REST_URL_PREFIX = "http://localhost:8001";

	//通过微服务名称在eureka找到并访问
	//Ribbon和Eureka整合后，Consumer可以通过服务名称直接调用服务而不用关心地址和端口号
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
    
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
         return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
         return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }
    
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
         return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    } 

  //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value="/consumer/dept/discovery") 
    public Object discovery()
    {
     return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
    } 
   


}
