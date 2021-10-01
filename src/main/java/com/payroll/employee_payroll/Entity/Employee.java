package com.payroll.employee_payroll.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.payroll.employee_payroll.dto.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name= "employee_payroll")
public @Data class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "empId")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private String salary;
	@Column(name = "start")
	private Date start;
	@Column(name = "gender")
	private String gender;
	@NotBlank(message = "Note should not be blank")
	@Column(name = "note")
	private String note;
	@NotBlank(message = "Pic should not be empty")
	@Column(name = "profilePic")
	private String profilePic;
	
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name="employee_department",joinColumns=@JoinColumn(name="id"))
	@Column(name="department")
	private List<String> department;

	public Employee(EmployeeDto employeeDto) {
		super();
		this.name = employeeDto.getName();
		this.salary = employeeDto.getSalary();
		this.start = employeeDto.getStart();
		this.gender = employeeDto.getGender();
		this.note = employeeDto.getNote();
		this.profilePic = employeeDto.getProfilePic();
		this.department = employeeDto.getDepartment();
	}
	
	public Employee() {
		
	}
}
