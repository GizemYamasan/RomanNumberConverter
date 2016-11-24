package com.yamasan.service.impl;

import org.springframework.stereotype.Component;

import com.yamasan.entity.RomanNumber;
import com.yamasan.entity.RomanNumber.RomanDigits;
import com.yamasan.service.NumberConverterService;

@Component
public class NumberConverterServiceImpl implements NumberConverterService{

	@Override
	public RomanNumber convertToRoman(Integer wholeNumber) {
		RomanNumber romanNumber = new RomanNumber();
		romanNumber.setWholeNumber(wholeNumber);
		
		StringBuilder romanNumberBuilder = new StringBuilder(); 
		RomanDigits[] romanDigits = RomanDigits.values();
		for (RomanDigits romanDigit : romanDigits) {
			int divider = romanDigit.getWholeNumber();
			if(wholeNumber == 0)
				break;
			int division = wholeNumber/divider;
			int remaining = wholeNumber%divider;
			
			if(division>0) {
				for(int i=0; i<division;i++){
					romanNumberBuilder.append(romanDigit.name());
				}
			}
			wholeNumber = remaining;
		}
		
	    romanNumber.setRomanNumber(romanNumberBuilder.toString());
	    return romanNumber;
	}
	
	

}
