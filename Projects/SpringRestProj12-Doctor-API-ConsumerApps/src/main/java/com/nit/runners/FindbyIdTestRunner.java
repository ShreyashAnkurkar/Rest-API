package com.nit.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FindbyIdTestRunner implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		try {
			String url="http://localhost:8080/SpringRestProj11-DoctorAPI-MiniProject-OpenAPI/Doctor-api/find/{id}";
			
			//invoke the endPoint
			ResponseEntity<String> resp=template.getForEntity(url,String.class,8);
			
			//analyse the output
			System.out.println("Response Content(String jSon)::"+resp.getBody());
			System.out.println("Response StatusCode::"+resp.getStatusCode());
			System.out.println("Response Header::"+resp.getHeaders());
			System.exit(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
