package com.aurionpro.payments.exceptions;

public class MinAccountBalanceException extends RuntimeException {
	private static int MIN_BALANCE = 500;

	 public MinAccountBalanceException(int balance) {
	        super("Minimum balance violation. Current: " + balance + ", Required: " + MIN_BALANCE);
	    }

}
