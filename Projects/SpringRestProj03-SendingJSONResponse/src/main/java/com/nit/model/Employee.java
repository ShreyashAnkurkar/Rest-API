package com.nit.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer eNo;
	private String name;
	private String[] friends;
	private Boolean isSingle;
	private List<String> nickNames;
	private Set<Long> phoneNo;
	private Map<String,Object> idDetails;
	private Company company; 
}
