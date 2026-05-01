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
public class UpdateTestRunner implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			String url="http://localhost:8080/SpringRestProj11-DoctorAPI-MiniProject-OpenAPI/Doctor-api/updateDoctorDetails";
			
			DoctorVo vo=new DoctorVo(15,"Tony","Newyork",10000.0,"Phychologiest");
			
			ObjectMapper mapper=new ObjectMapper();
			String json=mapper.writeValueAsString(vo);
			HttpHeaders header=new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity=new HttpEntity<String>(json,header);
			
			ResponseEntity<String> res=template.exchange(url, HttpMethod.PUT,entity,String.class);
			System.out.println(res.getBody());
			System.out.println(res.getStatusCode());
			
		}catch(Exception e) {
			
		}
		
	}

}
