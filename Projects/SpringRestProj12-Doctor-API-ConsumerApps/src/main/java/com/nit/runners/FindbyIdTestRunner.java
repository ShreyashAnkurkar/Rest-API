package com.nit.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nit.model.DoctorVo;

//@Component
public class FindbyIdTestRunner implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		try {
			String url="http://localhost:8080/SpringRestProj11-DoctorAPI-MiniProject-OpenAPI/Doctor-api/find/{id}";
			
			//getting directly the response as DoctorVo class object
			
				DoctorVo vo=template.getForObject(url, DoctorVo.class,8);
				System.out.println("Vo class Object data::" +vo);
			//invoke the endPoint
//			ResponseEntity<String> resp=template.getForEntity(url,String.class,8);
//			
//			//analyse the output
//			System.out.println("Response Content(String jSon)::"+resp.getBody());
//			System.out.println("Response StatusCode::"+resp.getStatusCode());
//			System.out.println("Response Header::"+resp.getHeaders());
//			System.exit(0);
			
			//using getForObject(-) method
			
//			String response=template.getForObject(url, String.class,8);
//			System.out.println("Response Content(String jSon)::"+response);
//			
//			ObjectMapper mapper=new ObjectMapper();
//			DoctorVo vo=mapper.readValue(response, DoctorVo.class);
//			System.out.println("Vo class Object data::"+vo);
				
				ResponseEntity<DoctorVo> r=template.exchange(url, HttpMethod.GET,null,DoctorVo.class,8);
				System.out.println("Exchange method::"+r.getBody());
				System.out.println("Response StatusCode::"+r.getStatusCode());
				System.out.println("Response Header::"+r.getHeaders());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
