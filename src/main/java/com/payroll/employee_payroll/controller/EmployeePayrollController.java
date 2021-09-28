package com.payroll.employee_payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.payroll.employee_payroll.component.EmployeeConvertor;
import com.payroll.employee_payroll.repo.MyRepo;
import com.payroll.employee_payroll.repo.Entity.Employee;
import com.payroll.employee_payroll.repo.dto.EmployeeDto;
import com.payroll.employee_payroll.service.ForService;


@RestController
public class EmployeePayrollController {
	
	@Autowired
	MyRepo myRepo;
	
	@Autowired
	ForService forService;
	
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
	
	@RequestMapping("/finds/{id}")
	public Employee findByIds(@PathVariable(value = "id") int id) {
		Employee emp = myRepo.findById(id).orElse(null);
		return emp;
	}
	
	@PostMapping("/save")
	public Employee findById(@RequestBody Employee emp) {
		myRepo.save(emp);
		return emp;
	}
	
	@DeleteMapping("/delete/{id}")
	public void findAndDeleteById(@PathVariable(value = "id") int id) {
		myRepo.deleteById(id);
	}
	
	@PutMapping("/put/{id}")
	public void putById(@RequestBody Employee empployee,@PathVariable(value = "id") int id) {
		myRepo.save(empployee);
	}
	
	@RequestMapping("/storeInMemory")
	public void forStoring() {
		forService.forStoringInMemory();	
	}
}
