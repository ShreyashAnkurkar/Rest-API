package com.nit.runners;

import java.util.ArrayList;
import java.util.List;

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
public class SaveAllTestRunner implements CommandLineRunner{
	
	@Autowired
	private RestTemplate templete;	

	@Override
	public void run(String... args) throws Exception {
		try {
		String url="http://localhost:8080/SpringRestProj11-DoctorAPI-MiniProject-OpenAPI/Doctor-api/saveAll";
		
		DoctorVo vo=new DoctorVo("Jayesh","Pune",150.0,"Urologiest");
		DoctorVo vo1=new DoctorVo("Abhay","Nagpur",100.0,"Urologiest");
		
		List<DoctorVo> list=new ArrayList<>();
		list.add(vo);
		list.add(vo1);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		
		//prepare header
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		//prepare http entity object having body and header
		HttpEntity<String> entity=new HttpEntity<String>(json,header);
		
		ResponseEntity<String> resp= templete.exchange(url, HttpMethod.POST,entity,String.class);
		System.out.println(resp.getBody());
		System.out.println(resp.getStatusCode());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
