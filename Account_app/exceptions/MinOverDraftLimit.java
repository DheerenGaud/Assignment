package com.aurionpro.payments.exceptions;

public class MinOverDraftLimit extends RuntimeException {
	private int MIN_OVERDARFT_AMOUT = 100000;
	private int balance;

	public MinOverDraftLimit(int balance) {
		if (balance < MIN_OVERDARFT_AMOUT) {
			this.balance = balance;
			System.out.println("Min MIN OVERDARFT limit hit ");
		}

	}

	public String getMessage() {
		return "Min MIN OVERDARFT limit hit !!!" + "Your Balance is : " + balance + " it shoud be minimum " + MIN_OVERDARFT_AMOUT;
	}
}
