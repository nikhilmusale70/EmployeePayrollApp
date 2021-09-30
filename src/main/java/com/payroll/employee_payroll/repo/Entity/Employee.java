package com.payroll.employee_payroll.repo.Entity;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;

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
	@Pattern(regexp = "male|female", message = "Gender needs to be male or female")
	private String gender;
	@NotBlank(message = "Note should not be blank")
	String note;
	@NotBlank(message = "Pic should not be empty")
	String profilePic;
	public ArrayList<String> department;
}
