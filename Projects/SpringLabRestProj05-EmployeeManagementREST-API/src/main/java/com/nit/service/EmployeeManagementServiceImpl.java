package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Employee;
import com.nit.repository.IEmployeeRepository;
import com.nit.vo.EmployeeVo;

@Service
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {
   
	@Autowired
	private IEmployeeRepository er;

	@Override
	public String saveEmployee(EmployeeVo e) {
		Employee emp=new Employee();
		BeanUtils.copyProperties(e, emp);
		return "Employee with id value"+er.save(emp).getId()+"saved";
	}

	@Override
	public List<EmployeeVo> getAllEmployees() {
		List<Employee> result=er.findAll();
		
		List<EmployeeVo> listvo=new ArrayList<>();
		result.forEach((vo)->{
			EmployeeVo e=new EmployeeVo();
			BeanUtils.copyProperties(vo, e);
			listvo.add(e);
		});

		return listvo;
	}

	@Override
	public EmployeeVo getEmployeeById(int id) {
		
		Employee emp=er.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
		EmployeeVo vo=new EmployeeVo();
		BeanUtils.copyProperties(emp, vo);
		return vo;
	}

	@Override
	public String updateEmployee(int id,EmployeeVo vo) {
		
		Employee emp=er.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id"));
		emp.setName(vo.getName());
		emp.setDepartment(vo.getDepartment());
		emp.setSalary(vo.getSalary());
		
		er.save(emp);
		return "employee with id ::"+id+" updated Successfully";
	}

	@Override
	public String deleteEmployee(int id) {
		
		Employee e=er.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id"));
		er.delete(e);
		return "Employee with id "+id+"Deleted successfully";
		
		

	}

}
