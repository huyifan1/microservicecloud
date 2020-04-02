package com.hyf.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hyf.springcloud.entities.Dept;
import com.hyf.springcloud.service.DeptService;

@RestController
public class DeptController
{
  @Autowired
  private DeptService service;
  @Autowired
  private DiscoveryClient client;
  
  @RequestMapping(value="/dept/add",method=RequestMethod.POST)
  public boolean add(@RequestBody Dept dept)
  {
   return service.add(dept);
  }
  
  @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
  public Dept get(@PathVariable("id") Long id)
  {
   return service.get(id);
  }
  
  @RequestMapping(value="/dept/list",method=RequestMethod.GET)
  public List<Dept> list()
  {
   return service.list();
  }
  
  //注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息。只是为了服务注册后的服务发现（不重要）
  @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
  public Object discovery()
  {
    List<String> list = client.getServices();
    System.out.println("**********" + list);
 
    List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
    for (ServiceInstance element : srvList) {
     System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
         + element.getUri());
    }
    return this.client;
  }

  
  
}
 
