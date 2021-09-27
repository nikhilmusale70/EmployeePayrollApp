package com.payroll.employee_payroll.component;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.payroll.employee_payroll.repo.Entity.Employee;
import com.payroll.employee_payroll.repo.dto.EmployeeDto;

@Component
public class EmployeeConvertor {

	public EmployeeDto entityToDto(Employee employee) {
		EmployeeDto dto = new EmployeeDto();
		dto.setName(employee.getName());
		dto.setSalary(employee.getSalary());	
		
		return dto;
	}
	
	public List<EmployeeDto> entityToDto(List<Employee> emp){
		List<EmployeeDto> employeeDto = null;
		for (Employee employee : emp) {
			employeeDto.add(entityToDto(employee));
		}
		
		return employeeDto;
	}
	
	
	public Employee dtoToEntity(EmployeeDto dto) {
		Employee employee = new Employee();
		employee.setName(dto.getName());
		employee.setSalary(dto.getSalary());
		
		return employee;
	}
	
	public List<Employee> dtoToEntity(List<EmployeeDto> empDto){
		List<Employee> employee = null;
		for (EmployeeDto employeeDto : empDto) {
			employee.add(dtoToEntity(employeeDto));
		}
		
		return employee;
	}
}
