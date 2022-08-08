package com.example.spinrgrest_yonghua.aop;

import com.example.spinrgrest_yonghua.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {UserNotFoundException.class})
	public ResponseEntity handleException(Exception e){
		return new ResponseEntity("user not found", HttpStatus.OK);
	}
}
