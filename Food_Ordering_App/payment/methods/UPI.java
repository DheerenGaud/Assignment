package com.aurionpro.payment.methods;

import java.util.Scanner;

import com.aurionpro.exceptions.PaymentExceptions;
import com.aurionpro.payment.details.UPIDetails;
import com.aurionpro.payment.model.IPayment;

public class UPI implements IPayment {
	UPIDetails detail;

	public UPI() {
		detail = new UPIDetails();
	}

	@Override
	public boolean pay(double ammount) {
		System.out.println("UPI Payment of " + ammount);
		return true;
	}

	@Override
	public void collectDetails(Scanner in) {

		System.out.print("Enter UPI ID (e.g. name@icic): ");
		detail.setUpiId(in.next());

		System.out.print("Enter 4‑digit UPI PIN: ");
		detail.setPin(in.next());
        System.out.println("Backed OTP Ganrated : "+detail.getBackedOTP());
		System.out.print("Enter OTP received on phone: ");
		detail.setOtp(in.next());
	}

	public boolean validateDetails() {
     
		if (!detail.getUpiId().matches("^\\w+@(?:icic|ybl|oksbi)$")) {
			 throw new PaymentExceptions("INVALID UPI ID");
		}
		if (!detail.getPin().matches("\\d{4}")) {
			 throw new PaymentExceptions("INVALID PIN");
			
		}
		if (detail.getBackedOTP().equals(detail.getOtp())) {
			 throw new PaymentExceptions("INVALID OTP");
			
		}
		return true;
	}

	@Override
	public String getPayMethodName() {
		return "upi";
	}

}
