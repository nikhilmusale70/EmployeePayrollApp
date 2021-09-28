package com.payroll.employee_payroll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.employee_payroll.repo.MyRepo;
import com.payroll.employee_payroll.repo.Entity.Employee;

@Service
public class ForService {
	@Autowired
	MyRepo repo;
	
	static	List<Employee> emp = new ArrayList<>();
	
	public void forStoringInMemory() {
		 emp = repo.findAll();
	}
	
	public void forTest() {
		System.out.println(emp.get(0).getName());
	}
	
}
