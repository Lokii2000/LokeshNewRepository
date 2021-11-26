package com.SpringStarter.Springcontroller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/spring-boot-actuator")
public class SpringController {
	
	
	@GetMapping(value="/student")
	public String getStudent() {
		String s1;
		return "new Student";
	}
   @GetMapping("/test")
   public String testendpoint(){
	   String uri = "http://localhost:8080/spring-boot-actuator/student";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    return result; 
	 
//	   return "Lokesh";
   }
   @GetMapping("/test1")
   public String testendpoint1(){
	   String uri = "http://localhost:8080/nextpath/Stringpath";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    return result; 
	 

   }
   @GetMapping("/testHealth")
   public Health testHealth() {
	   HealthCheck obj1=new HealthCheck();
	   String str=obj1.health().toString();
	   System.out.println(obj1.health().toString());
	   System.out.println(str);
//	   if(str=="UP {}") {
//		    String uri = "http://localhost:8080/nextpath/HeathReturn";
//		    RestTemplate restTemplate = new RestTemplate();
//		    String result = restTemplate.getForObject(uri, String.class);
//		    result=Health(result);
//		    return result; 
//		 
//	   }
	   return obj1.health();
	   
   }
   @GetMapping(value ="/Stringtest")
   public String healthtostring() {
	   HealthCheck obj2=new HealthCheck();	
	   String s=obj2.health().toString();
	   
	   if(s=="UP {}") {
		   String uri="http://localhost:8080/nextpath/Stringpath";
		   RestTemplate r=new RestTemplate();
		   String result1=r.getForObject(uri, String.class);
		   return result1;
	   }
	   else {
		   s=s+"loki";
	       return s;
	   }
   }
   @Component("myHealthCheck")
   public class HealthCheck implements HealthIndicator {
    
       @Override
       public Health health() {
           int errorCode = check(); // perform some specific health check
           if (errorCode != 0) {
               return Health.down()
                 .withDetail("Error Code", errorCode).build();
           }
          // System.out.println(Health.up().build());
          // return Health.up().build();
           String str=Health.up().build().toString();
           Health h= Health.up().build();
          
           return h;
       }
       
       public int check() {
       	// Our logic to check health
       	return 0;
       }
   }
   }
