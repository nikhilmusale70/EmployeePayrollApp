package com.payroll.employee_payroll.Entity;

import java.sql.Date;
import java.util.ArrayList;
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
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Entity
@Table(name= "employee_payroll")
public @Data class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "empId")
	private int id;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message ="Name invalid")
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private String salary;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "start")
	private Date start;
	@Pattern(regexp = "male|female", message = "Gender needs to be male or female")
	@Column(name = "gender")
	private String gender;
	@NotBlank(message = "Note should not be blank")
	@Column(name = "note")
	String note;
	@NotBlank(message = "Pic should not be empty")
	@Column(name = "profilePic")
	String profilePic;
	
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name="employee_department",joinColumns=@JoinColumn(name="id"))
	@Column(name="department")
	public List<String> department;
}
