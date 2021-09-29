package com.payroll.employee_payroll.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.payroll.employee_payroll.repo.Entity.Employee;

@Service
public class ForService {
	
	static	List<Employee> empList = new ArrayList<>();
	

	public void add(Employee employee) {
		int index = empList.size();
		employee.setId(index);
		empList.add(index, employee);
	}
	
	public List<Employee> findAll() {
		return empList;
	}
	
	public Employee findById(int id) {
		return empList.get(id);
	}
	
	public void put(int id,Employee pm) {
		empList.remove(id);
		empList.add(id,pm);
	}
	
	public void delete(int id) {
		empList.remove(id);
	}
	
}
