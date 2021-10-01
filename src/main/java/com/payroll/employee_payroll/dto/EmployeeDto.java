package com.payroll.employee_payroll.dto;

import java.sql.Date;
import java.util.List;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

public @Data class EmployeeDto {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message ="Employee name invalid")
	private String name;
	private String salary;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date start;
	@Pattern(regexp = "male|female", message = "Gender needs to be male or female")
	private String gender;
	private String note;
	private String profilePic;
	public List<String> department;

}
