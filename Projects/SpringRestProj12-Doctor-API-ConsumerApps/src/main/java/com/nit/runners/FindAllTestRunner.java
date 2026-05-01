package com.nit.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nit.model.DoctorVo;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

//@Component
public class FindAllTestRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			String url="http://localhost:8080/SpringRestProj11-DoctorAPI-MiniProject-OpenAPI/Doctor-api/showAllDoctors";
			
			ResponseEntity<String> resp=template.exchange(url, HttpMethod.GET,null,String.class);
			
			System.out.println("Response content::"+resp.getBody());
			System.out.println("Response status code: "+resp.getStatusCode());
			System.out.println("Response header::"+resp.getHeaders());
			
			//convert array of json into List of Vo obejcts
			
			ObjectMapper mapper=new ObjectMapper();
			List<DoctorVo> vo=mapper.readValue(resp.getBody(), new TypeReference<List<DoctorVo>>() {});
			
			vo.forEach(System.out::println);
			System.exit(0);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
