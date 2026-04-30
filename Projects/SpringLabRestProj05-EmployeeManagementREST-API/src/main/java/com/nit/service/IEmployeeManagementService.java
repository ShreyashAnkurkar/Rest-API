package com.nit.service;

import java.util.List;

import com.nit.entity.Employee;
import com.nit.vo.EmployeeVo;

public interface IEmployeeManagementService {
	public String saveEmployee(EmployeeVo e);

	public List<EmployeeVo> getAllEmployees();

	public EmployeeVo getEmployeeById(int id);

	public String updateEmployee(int id,EmployeeVo vo);

	public String deleteEmployee(int id);
}
