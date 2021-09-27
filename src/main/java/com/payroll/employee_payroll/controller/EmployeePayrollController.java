package com.payroll.employee_payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.employee_payroll.component.EmployeeConvertor;
import com.payroll.employee_payroll.repo.MyRepo;
import com.payroll.employee_payroll.repo.Entity.Employee;
import com.payroll.employee_payroll.repo.dto.EmployeeDto;

@RestController
public class EmployeePayrollController {
	
	@Autowired
	MyRepo myRepo;
	
	@Autowired
	EmployeeConvertor employeeConvertor;
	
	@RequestMapping("/findAll")
	public List<EmployeeDto> getData() {
		List<Employee> emp = myRepo.findAll();
		return employeeConvertor.entityToDto(emp);
	}
	
	@RequestMapping("/find/{id}")
	public EmployeeDto findById(@PathVariable(value = "id") int id) {
		Employee emp = myRepo.findById(id).orElse(null);
		return employeeConvertor.entityToDto(emp);
	}
	
	@PostMapping("/save")
	public EmployeeDto findById(@RequestBody EmployeeDto empDto) {
		Employee emp = employeeConvertor.dtoToEntity(empDto);
		myRepo.save(emp);
		return empDto;
	}
}
