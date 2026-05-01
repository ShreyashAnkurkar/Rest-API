package com.nit.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@Component
public class PatchUpdateTestRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			String url="http://localhost:8080/SpringRestProj11-DoctorAPI-MiniProject-OpenAPI/Doctor-api/hikeFeeById/{id}/{hp}";
			//active the patch mode
			template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			ResponseEntity<String> resp=template.exchange(url, HttpMethod.PATCH,null,String.class,8,24.0);
			System.out.println(resp.getBody());
			System.out.println(resp.getStatusCode());
			System.exit(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
