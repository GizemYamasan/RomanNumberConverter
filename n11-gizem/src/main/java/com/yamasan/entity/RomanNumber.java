package com.yamasan.entity;

public class RomanNumber {
	
	public enum RomanDigits{
		
		M(1000),
		CM(900),
		D(500),
		CD(400),
		C(100),
		XC(90),
		L(50),
		XL(40),
		X(10),
		IX(9),
		V(5),
		IV(4),
		I(1);
		
		private int wholeNumber;
		RomanDigits(int wholeNumber) {
			
			this.wholeNumber = wholeNumber;
			
		}
		
		public int getWholeNumber() {
			return wholeNumber;
		}
		
	}

	private Integer wholeNumber;
	private String romanNumber;

	public Integer getWholeNumber() {
		return wholeNumber;
	}

	public void setWholeNumber(Integer wholeNumber) {
		this.wholeNumber = wholeNumber;
	}

	public String getRomanNumber() {
		return romanNumber;
	}

	public void setRomanNumber(String romanNumber) {
		this.romanNumber = romanNumber;
	}

	@Override
	public String toString() {
		return "RomanNumber [wholeNumber=" + wholeNumber + ", romanNumber=" + romanNumber + "]";
	}

}
