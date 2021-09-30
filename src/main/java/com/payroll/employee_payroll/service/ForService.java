package com.payroll.employee_payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.employee_payroll.Entity.Employee;
import com.payroll.employee_payroll.repo.MyRepo;

@Service
public class ForService {
	
	@Autowired
	MyRepo myRepo;
		
	public void add(Employee employee) {
		myRepo.save(employee);
	}
	
	public List<Employee> findAll() {
		return myRepo.findAll();
	}
	
	public Employee findById(Integer id) {
		return myRepo.findById(id).orElse(null);
	}
	
	public void put(Integer id,Employee pm) {
		Employee employee = myRepo.findById(id).orElse(null);
		employee.setName(pm.getName());
		employee.setGender(pm.getGender());
		employee.setNote(pm.getNote());
		employee.setDepartment(pm.department);
		employee.setProfilePic(pm.getProfilePic());
		employee.setSalary(pm.getSalary());
		employee.setStart(pm.getStart());
		
		myRepo.save(employee);
	}
	
	public void delete(int id) {
		myRepo.deleteById(id);
	}
	
}
