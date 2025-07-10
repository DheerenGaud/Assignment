package com.aurionpro.payments.account.model;

import com.aurionpro.payments.exceptions.MinOverDraftLimit;

public class CurrentAccount extends Account {
	static private int OVER_DRAFT_LIMIT = 100000;

	public static int getOVER_DRAFT_LIMIT() {
		return OVER_DRAFT_LIMIT;
	}

	public static void setOVER_DRAFT_LIMIT(int oVER_DRAFT_LIMIT) {
		OVER_DRAFT_LIMIT = oVER_DRAFT_LIMIT;
	}

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(String accountNumber, String name, int balance) {
		super(accountNumber, name, balance, AccountType.current);
	}
	public  boolean withdrawValidation(int amount) {
		if(Math.abs(super.getBalance() - amount) > OVER_DRAFT_LIMIT) {
			try {
				throw new MinOverDraftLimit(super.getBalance());
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
//		if (Math.abs(super.getBalance() - amount) > OVER_DRAFT_LIMIT) {
//			System.out.println("You did't have enough balnce");
//			return false;
//		}
		return true;
	}
	
	@Override
	public void deposit(int amount) {
	 {
	   	if (amount<=0) {
	   		System.out.println("Amount shoud be +ve or gretar then 0");
	   	}
	   	else {
	   		super.setBalance(super.getBalance()+amount);
	   	}
	  
	 }
	}
	
	
	public void withdraw(int amount) {
		if (super.getBalance() >= amount) {
			if (amount >= super.getBalance()) {
		   		System.out.println("You did't have enough balnce");
		   	}
		   	else if(super.getBalance()-amount<500){
		   		System.out.println("minimun amount shoud be 500");
		   	}
		   	else {
		   		super.setBalance(super.getBalance()-amount);
		   	}
			return;
		}
		if (Math.abs(super.getBalance() - amount) < OVER_DRAFT_LIMIT) {
			System.out.println("Dont have enough Balance... so Your OverDraft Balance is Useing");
			System.out.println("Over draft balance used "+ Math.abs(super.getBalance() - amount));
			super.setBalance(super.getBalance() - amount);
			return;
		}
		System.out.println("Dont have enough Balance..., you have limited your Overdarft Balnce ");
		return;
	}

}
