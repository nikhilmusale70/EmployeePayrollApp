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
import org.springframework.web.bind.annotation.RestController;
import com.payroll.employee_payroll.Entity.Employee;
import com.payroll.employee_payroll.service.ForService;


@RestController
public class EmployeePayrollController {
	
	@Autowired
	ForService employeeService;
	
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
	public String findAndDeleteById(@PathVariable(value = "id") int id) {
		employeeService.delete(id);
		return "Deleted";
	}
	
	@PutMapping("/put/{id}")
	public String putById(@RequestBody Employee empployee,@PathVariable(value = "id") int id) {
		employeeService.put(id,empployee);
		return "Updated";
	}
	
}
