package com.aurionpro.payments.account.model;

import com.aurionpro.payments.exceptions.MinAccountBalanceException;

public class SavingAccount extends Account {
	static private int MIN_BALANCE_LIMT = 500;

	public static int getMIN_BALANCE_LIMT() {
		return MIN_BALANCE_LIMT;
	}

	public static void setMIN_BALANCE_LIMT(int mIN_BALANCE_LIMT) {
		MIN_BALANCE_LIMT = mIN_BALANCE_LIMT;
	}

	public SavingAccount() {
		super();

	}

	public boolean withdrawValidation(int amount) {
		
			if(super.getBalance() - amount < 500) {
				throw new MinAccountBalanceException(amount);
			}
			if (amount >= super.getBalance()) {
				System.out.println("You did't have enough balnce");
				return false;
			} 
			return true;
		
		
	}

	public SavingAccount(String accountNumber, String name, int balance) {
		super(accountNumber, name, balance, AccountType.saving);
	}

	public void withdraw(int amount) {
		
		super.setBalance(super.getBalance() - amount);

	}

	@Override
	public void deposit(int amount) {
		{
			if (amount <= 0) {
				System.out.println("Amount shoud be +ve or gretar then 0");
			} else {
				super.setBalance(super.getBalance() + amount);
			}

		}
	}
}
