package com.nit.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nit.model.DoctorVo;

import tools.jackson.databind.ObjectMapper;

//@Component
public class SaveTestRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		
		try {
			String url="http://localhost:8080/SpringRestProj11-DoctorAPI-MiniProject-OpenAPI/Doctor-api/registerDoctor";
			
			//preparing json data to send as request body
//			String json = """
//					{
//					  "dname": "Amit Sharma",
//					  "address": "Mumbai",
//					  "fees": 750.0,
//					  "specialization": "Cardiology"
//					}
//					""";
			
			//using vo object instead of writing string json
			
			DoctorVo vo=new DoctorVo("Mukesh","Hydrabad",1500.0,"Urologiest");
			
			ObjectMapper mapper=new ObjectMapper();
			String json=mapper.writeValueAsString(vo);
			
			//prepare header
			HttpHeaders header=new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			
			//prepare http entity object having body and header
			HttpEntity<String> entity=new HttpEntity<String>(json,header);
			
			//invoke the method
			
			ResponseEntity<String> resp=template.exchange(url, HttpMethod.POST,entity,String.class);
			System.out.println(resp.getBody());
			System.out.println(resp.getStatusCode());
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
