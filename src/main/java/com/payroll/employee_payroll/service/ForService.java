package com.payroll.employee_payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.employee_payroll.Entity.Employee;
import com.payroll.employee_payroll.dto.EmployeeDto;
import com.payroll.employee_payroll.exception.EmployeePayrollException;
import com.payroll.employee_payroll.repo.MyRepo;

@Service
public class ForService implements InterfaceService {
	
	@Autowired
	MyRepo myRepo;
		
	@Override
	public void add(EmployeeDto employeeDto) {
		Employee emp = new Employee(employeeDto);
		myRepo.save(emp);
	}
	
	@Override
	public List<Employee> findAll() {
		return myRepo.findAll();
	}
	
	@Override
	public Employee findById(int id){
		return myRepo.findById((Integer)id).orElseThrow(()->new EmployeePayrollException("Id not found"));
	}
	
	@Override
	public void put(int id,EmployeeDto eDto){
		Employee employee = myRepo.findById((Integer)id).orElseThrow(()->new EmployeePayrollException("Id not found"));
		employee = new Employee(eDto);
		myRepo.save(employee);
	}
	
	@Override
	public void delete(int id) {
		myRepo.deleteById((Integer)id);
	}

}
