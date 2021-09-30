	package com.payroll.employee_payroll.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.employee_payroll.Entity.Employee;

@Repository
public interface MyRepo extends JpaRepository<Employee, Integer>{

}
