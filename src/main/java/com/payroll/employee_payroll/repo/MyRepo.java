package com.payroll.employee_payroll.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payroll.employee_payroll.repo.Entity.Employee;


public interface MyRepo extends JpaRepository<Employee, Integer>{

}
