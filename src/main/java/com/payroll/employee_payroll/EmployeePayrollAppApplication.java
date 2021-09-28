package com.payroll.employee_payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {


	
	public static void main(String[] args) {
		log.error("Application is working, and logging is working fine");
		SpringApplication.run(EmployeePayrollAppApplication.class, args);
	}

}
