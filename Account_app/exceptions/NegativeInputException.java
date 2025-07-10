package com.aurionpro.payments.exceptions;

public class NegativeInputException extends RuntimeException {
    
	public NegativeInputException(int input) {
		if(input<0) {
			System.out.println("Negative input Found");
		}
	}
	public String getMessage() {
	  return "Negative input Found !!! enter positive value";
	}
}
