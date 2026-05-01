package com.nit.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteByRangeTestRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			String url="http://localhost:8080/SpringRestProj11-DoctorAPI-MiniProject-OpenAPI/Doctor-api/deleteByFeeRange/{start}/{end}";
			
			ResponseEntity<String> resp=template.exchange(url, HttpMethod.DELETE,null,String.class,400,700);
			System.out.println(resp.getBody());
			System.out.println(resp.getStatusCode());
			System.exit(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
