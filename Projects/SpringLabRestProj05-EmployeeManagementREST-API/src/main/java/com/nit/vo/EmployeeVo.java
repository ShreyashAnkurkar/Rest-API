package com.nit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVo {
    
	private Integer id;
    private String name;
	private String department;
	private Double salary;
}
