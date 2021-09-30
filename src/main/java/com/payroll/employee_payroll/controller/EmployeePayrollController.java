package com.payroll.employee_payroll.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.payroll.employee_payroll.component.EmployeeConvertor;
import com.payroll.employee_payroll.repo.Entity.Employee;
import com.payroll.employee_payroll.service.ForService;


@RestController
public class EmployeePayrollController {
	
	@Autowired
	ForService employeeService;
	
	@Autowired
	EmployeeConvertor employeeConvertor;
		
	@GetMapping("/findAll")
	public List<Employee> getData() {
		List<Employee> emp = employeeService.findAll();
		return emp;
	}
	
	@GetMapping("/finds/{id}")
	public Employee findByIds(@PathVariable(value = "id") int id) {
		Employee emp = employeeService.findById(id);
		return emp;
	}
	
	@PostMapping("/save")
	public Employee findById(@Valid @RequestBody Employee emp) {
		employeeService.add(emp);
		return emp;
	}
	
	@DeleteMapping("/delete/{id}")
	public void findAndDeleteById(@PathVariable(value = "id") int id) {
		employeeService.delete(id);
	}
	
	@PutMapping("/put/{id}")
	public void putById(@RequestBody Employee empployee,@PathVariable(value = "id") int id) {
		employeeService.put(id,empployee);
	}
	
}
