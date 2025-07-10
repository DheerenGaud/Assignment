package com.aurionpro.payments.model;

import com.aurionpro.payments.account.model.Account;

public class Paypal implements Payment {
	public boolean pay(int amount, Account sender, Account receivere) {
		System.out.println("Payment by PayPal Started");
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

	@Override
	public boolean validateDetails(PaymentDetails detail) {

		if (!(detail instanceof PaypalDetails)) {
			System.out.println("Invalid details type");
			return false;
		}

          PaypalDetails payPalDetail = (PaypalDetails) detail;


		if (!payPalDetail.getEmail().matches("^\\w+@(?:gmail.com)$")) {
			System.out.println("INVALID UPI ID");
			return false;
		}
		String backendToken = "567vdhf93798039$#%^*";
		if (!payPalDetail.getToken().equals(backendToken)) {
			System.out.println("INVALID token");
			return false;
		}
		return true;
	}
}
