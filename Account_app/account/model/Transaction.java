package com.aurionpro.payments.account.model;

import java.time.LocalDate;

public class Transaction {
	private TransactionType type;
	private TransactionMethods method;
	private LocalDate date;
	private String transactionId;
	private String senderAccount;
	private String receiverAccount;

	private int amount;
	private TransactionStatus status=TransactionStatus.PENDING;



	public Transaction(TransactionType type, TransactionMethods method, LocalDate date, String transactionId, String senderAccount,String receiverAccount, int amount) {
		super();
		this.type = type;
		this.method = method;
		this.date = date;
		this.transactionId = transactionId;
		this.senderAccount = senderAccount;
		this.receiverAccount = receiverAccount;
		this.amount = amount;
	}
	public Transaction(TransactionType type,LocalDate date,String transactionId,int amount) {
		this.type = type;
		this.date = date;
		this.transactionId = transactionId;
		this.amount = amount;
	
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void markAsDone() {
		this.status = TransactionStatus.DONE;
	}

	public void markAsFailed() {
		this.status = TransactionStatus.FAILED;
	}

	public void cancel() {
		if (this.status == TransactionStatus.DONE) {
			throw new IllegalStateException("Cannot cancel a completed transaction.");
		}
		this.status = TransactionStatus.CANCELLED;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    sb.append("\n\n");
	    sb.append(" - Type           : ").append(type).append("\n");
	    if (method != null) {
	        sb.append(" - Method         : ").append(method).append("\n");
	        sb.append(" - From Account   : ").append(senderAccount).append("\n");
	        sb.append(" - To Account     : ").append(receiverAccount).append("\n");
	    }
	    sb.append(" - Date           : ").append(date).append("\n");
	    sb.append(" - Transaction ID : ").append(transactionId).append("\n");
	    sb.append(" - Amount         : ₹").append(amount).append("\n");
	    sb.append(" - Status         : ").append(status);

	    return sb.toString();
	}


}
