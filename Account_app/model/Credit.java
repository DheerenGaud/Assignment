package com.aurionpro.payments.model;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import com.aurionpro.payments.account.model.Account;

public class Credit implements Payment {


	public boolean pay(int amount, Account sender, Account receivere) {
		System.out.println("Payment by Credit Card Started");
		try {
			Thread.sleep(3000);
			if(sender.withdrawValidation(amount)) {
				sender.withdraw(amount);
				receivere.deposit(amount);
				System.out.println("Payment Successfull");
				return true;
			}
			return false;
		} catch (InterruptedException e) {
		    System.out.println(e.getMessage()+"Payment Faild ");
			return false;
		}
	}
	
	@Override
	public boolean validateDetails(PaymentDetails detail) {
	    
		try {
			if (!(detail instanceof CreditCardDetails)) {
				System.out.println("Invalid details type");
				return false;
			}

			CreditCardDetails creditCardDetail = (CreditCardDetails) detail;
			
			if(creditCardDetail.getCvv().matches("\\d{3}")) {
				System.out.println("INVAID CVV");
				return false;
			}
			
			YearMonth expiryDate = YearMonth.parse(creditCardDetail.getExpiry(), DateTimeFormatter.ofPattern("MM/yy"));
			if (expiryDate.isBefore(YearMonth.now())) {
			    System.out.println("INVALID Expiry");
			    return false;
			}

			
			if(creditCardDetail.getCardnNumber().matches("\\d{16}")) {
				System.out.println("INVAID CARD NUMBER");
				return false;
			}
			
			
		} catch (Exception e) {
			 System.out.println(e.getMessage() + "INVAID INPUT" );
			 return false;
		}
		
		return true;
	}


	
   	
}
