package com.aurionpro.payments.account.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Comparable<Account>  {
	private String accountNumber;
	private String name;
	private int balance;
	private AccountType accountType;
	private List<Transaction> transactionHistory;

	public Account() {

	}

	public abstract void deposit(int amount);

	public abstract void withdraw(int amount);
	
	public abstract boolean withdrawValidation(int amount);

	public Account(String accountNumber, String name, int balance, AccountType accountType) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.accountType = accountType;
		this.transactionHistory = new ArrayList<>();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void addTransaction(Transaction transaction) {
	
		transactionHistory.add(transaction);
	}

	public void history() {
					for (Transaction transaction : transactionHistory) {
				System.out.println(transaction);
			}
	
	}
	
	@Override
	public int compareTo(Account o) {
		return this.balance - o.getBalance();
	}
	
	@Override
	public String toString() {
	    double displayBalance = Math.max(balance, 0); // Prevent showing negative balances

	    StringBuilder sb = new StringBuilder();
	    sb.append("Account Details:\n");
	    sb.append(" - Account Number : ").append(accountNumber).append("\n");
	    sb.append(" - Name           : ").append(name).append("\n");
	    sb.append(" - Balance        : ₹").append(displayBalance).append("\n");
	    sb.append(" - Account Type   : ").append(accountType);

	    return sb.toString();
	}

}
