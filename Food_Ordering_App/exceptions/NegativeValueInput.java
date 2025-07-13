package com.aurionpro.exceptions;

public class NegativeValueInput extends RuntimeException {
	public NegativeValueInput(int value) {
		super("Invalid Input Exception , You enter Negative value : " + value);
	}
}
