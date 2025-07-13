package com.aurionpro.payment.methods;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.aurionpro.exceptions.PaymentExceptions;
import com.aurionpro.payment.details.DebitCardDetails;
import com.aurionpro.payment.model.IPayment;

public class Debit implements IPayment {

	private DebitCardDetails detail;

	public Debit() {
		detail = new DebitCardDetails();
	}

	public DebitCardDetails getDetail() {
		return detail;
	}

	@Override
	public boolean pay(double ammount) {
		System.out.println("UPI Payment of " + ammount);
		return true;
	}
	
	@Override
	public void collectDetails(Scanner in) {
	    System.out.print("Enter 16‑digit card number : ");
	    detail.setCardnNumber(in.next());

	    System.out.print("Enter expiry (MM/yy)       : ");
	    detail.setExpiry(in.next());

	    System.out.print("Enter CVV (3 digits)       : ");
	    detail.setCvv(in.next());

	}
	  public boolean validateDetails() {
		  System.out.println("In Validation");
	        
	            if (!detail.getCvv().matches("\\d{3}")) {
	                throw new PaymentExceptions("Invalid CVV");
	            }

	            YearMonth expiryDate = YearMonth.parse(detail.getExpiry(), DateTimeFormatter.ofPattern("MM/yy"));
	            if (expiryDate.isBefore(YearMonth.now())) {
	                throw new PaymentExceptions("Card expired");
	            }

	            if (!detail.getCardnNumber().matches("\\d{16}")) {
	                throw new PaymentExceptions("Invalid card number");
	            }

	        return true;
	    }

	@Override
	public String getPayMethodName() {
		return "debit";
	}

}
