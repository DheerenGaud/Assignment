package com.aurionpro.payment.details;


public class UPIDetails {
	private String upiId ;
	private String otp ;
	
	public String getBackedOTP() {
	    int otp = (int)(Math.random() * 9000) + 1000;
	    return String.valueOf(otp);
	}

	
	public String getUpiId() {
		return upiId;
	}
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	private String pin ;
}
