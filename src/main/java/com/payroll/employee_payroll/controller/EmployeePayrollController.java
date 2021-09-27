package com.payroll.employee_payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.employee_payroll.repo.MyRepo;
import com.payroll.employee_payroll.repo.Entity.Employee;

@RestController
public class EmployeePayrollController {
	
	@RequestMapping("/get")
	public List<Employee> getData() {
		
	}
}
