package com.payroll.employee_payroll.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.payroll.employee_payroll.Entity.Employee;
import com.payroll.employee_payroll.dto.EmployeeDto;
import com.payroll.employee_payroll.dto.ResponseDTO;
import com.payroll.employee_payroll.service.ForService;
import com.payroll.employee_payroll.service.InterfaceService;


@RestController
public class EmployeePayrollController {
	
	@Autowired
	InterfaceService interfaceService;
	
	@GetMapping("/findAll")
	public ResponseEntity<ResponseDTO> getData() {
		List<Employee> emp = interfaceService.findAll();
		ResponseDTO resp = new ResponseDTO("Get call success", emp);
		return new ResponseEntity<ResponseDTO>(resp,HttpStatus.OK);
	}
	
	@GetMapping("/finds/{id}")
	public ResponseEntity<ResponseDTO> findByIds(@PathVariable(value = "id") int id) {
		Employee emp = interfaceService.findById(id);
		ResponseDTO resp = new ResponseDTO("Get call success", emp);
		return new ResponseEntity<ResponseDTO>(resp,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<ResponseDTO> findById(@Valid @RequestBody EmployeeDto empDto) {
		interfaceService.add(empDto);
		ResponseDTO resp = new ResponseDTO("Get call success", empDto);
		return new ResponseEntity<ResponseDTO>(resp,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> findAndDeleteById(@PathVariable(value = "id") int id) {
		interfaceService.delete(id);
		ResponseDTO resp = new ResponseDTO("Get call success",id);
		return new ResponseEntity<ResponseDTO>(resp,HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<ResponseDTO> putById(@RequestBody EmployeeDto empployeeDto,@PathVariable(value = "id") int id) {
		interfaceService.put(id,empployeeDto);
		ResponseDTO resp = new ResponseDTO("Get call success", empployeeDto);
		return new ResponseEntity<ResponseDTO>(resp,HttpStatus.OK);
	}
	
}
