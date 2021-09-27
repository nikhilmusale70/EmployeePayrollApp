package com.payroll.employee_payroll.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePayrollContainer {
	
	@RequestMapping("/get")
	public String getData() {
		return "Working";
	}
}
