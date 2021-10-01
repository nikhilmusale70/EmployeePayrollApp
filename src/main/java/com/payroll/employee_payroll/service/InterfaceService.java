package com.payroll.employee_payroll.service;

import java.util.List;

import javax.validation.Valid;

import com.payroll.employee_payroll.Entity.Employee;
import com.payroll.employee_payroll.dto.EmployeeDto;

public interface InterfaceService {

	List<Employee> findAll();

	Employee findById(int id);

	void add(@Valid EmployeeDto empDto);

	void delete(int id);

	void put(int id, EmployeeDto empployeeDto);
	
}
