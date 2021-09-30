package com.payroll.employee_payroll.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.UnexpectedTypeException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.payroll.employee_payroll.dto.ResponseDTO;


@ControllerAdvice
public class AddressBookExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		
		List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
		List<String> errMesg=errorList.stream()
				.map(objErr->objErr.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO=new ResponseDTO("Exception while processing REST request",errMesg);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<ResponseDTO> handleAddressNotException(IndexOutOfBoundsException exception){
		ResponseDTO responseDTO=new ResponseDTO("Exception while Accesing employee with given id",exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<ResponseDTO> handleAddressNotException(UnexpectedTypeException exception){
		ResponseDTO responseDTO=new ResponseDTO("Exception while adding",exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ResponseDTO> handleAddressNotException(EmptyResultDataAccessException exception){
		ResponseDTO responseDTO=new ResponseDTO("No id is there",exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseDTO> handleAddressNotException(NullPointerException exception){
		ResponseDTO responseDTO=new ResponseDTO("No such id is there",exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
}
