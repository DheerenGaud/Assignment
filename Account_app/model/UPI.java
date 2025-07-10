package com.aurionpro.payments.model;

import com.aurionpro.payments.account.model.Account;

public class UPI implements Payment{
	public boolean pay(int amount, Account sender, Account receivere) {
		System.out.println("Payment by UPI Started");
		try {
			Thread.sleep(3000);
			if (sender.withdrawValidation(amount)) {
				sender.withdraw(amount);
				receivere.deposit(amount);
				System.out.println("Payment Successfull");
				return true;
			}
			return false;
		} catch (InterruptedException e) {
			System.out.println(e.getMessage() + "Payment Faild ");
			return false;
		}
	}
	
	public boolean validateDetails(PaymentDetails detail ) {
		
		if (!(detail instanceof UPIDetails)) {
			System.out.println("Invalid details type");
			return false;
		}

		UPIDetails upiDetail = (UPIDetails) detail;

		if (!upiDetail.getUpiId().matches("^\\w+@(?:icic|ybl|oksbi)$")) {
			System.out.println("INVALID UPI ID");
		    return false;
		}
		if(!upiDetail.getPin().matches("\\d{4}")) {
			System.out.println("INVALID PIN");
		    return false;
		}
		if(upiDetail.getBackedOTP()!=upiDetail.getOtp()) {
			System.out.println("INVALID OTP");
			return false;
		}
		return true;
	}

}
