package com.payroll.employee_payroll.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class EmployeeDto {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message ="Employee name invalid")
	private String name;
	private String salary;
}
