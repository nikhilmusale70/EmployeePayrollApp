package com.payroll.employee_payroll.repo.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name= "employee_payroll")
public @Data class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message ="Name invalid")
	private String name;
	private String salary;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date start;
	private char gender;
}
