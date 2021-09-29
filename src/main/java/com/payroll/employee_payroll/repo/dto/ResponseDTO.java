package com.payroll.employee_payroll.repo.dto;

import lombok.Data;

public @Data class ResponseDTO {
	
	private String message;
	private Object data;
	
	public ResponseDTO(String message,Object data) {
		this.message = message;
		this.data = data;
	}
}
