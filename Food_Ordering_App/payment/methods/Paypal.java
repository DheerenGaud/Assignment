package com.aurionpro.payment.methods;

import java.util.Scanner;

import com.aurionpro.exceptions.PaymentExceptions;
import com.aurionpro.payment.details.PaypalDetails;
import com.aurionpro.payment.model.IPayment;

public class Paypal implements IPayment {
	PaypalDetails detail;

	public Paypal() {
		detail = new PaypalDetails();
	}

	@Override
	public void collectDetails(Scanner in) {

		System.out.print("PayPal email (gmail only in demo): ");
		detail.setEmail(in.next());
        
		System.out.println("token : abcd123" );
		System.out.print("Approval token (copy‑paste from PayPal): ");
		detail.setToken(in.next());

	}

	@Override
	public boolean pay(double ammount) {
		System.out.println("UPI Payment of " + ammount);
		return true;
	}

	@Override
	public boolean validateDetails() {

		if (!detail.getEmail().matches("^\\w+@(?:gmail.com)$")) {
			 throw new PaymentExceptions("INVALID UPI ID");
		}
		String backendToken = "abcd123";
		if (!detail.getToken().equals(backendToken)) {
			 throw new PaymentExceptions("INVALID token");
			
		}
		return true;
	}

	@Override
	public String getPayMethodName() {
		return "paypal";
	}

}
