package com.yamasan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yamasan.entity.RomanNumber;
import com.yamasan.service.NumberConverterService;

@RestController
public class ConverterController {
	
	@Autowired
	private NumberConverterService service;
	
	@RequestMapping("/convert")
	@ResponseBody
	public RomanNumber convert(@RequestParam(name="whole-number") Integer wholeNumber){
		
		if(wholeNumber==null || wholeNumber<=0)
			throw new IllegalArgumentException("Input must be positive integer");
		
		RomanNumber romanNumber = service.convertToRoman(wholeNumber);
		return romanNumber;
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public String exceptionHandler(Exception e){
		String message = e.getMessage();
		return message;
	}

}
