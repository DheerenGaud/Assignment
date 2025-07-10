package com.aurionpro.payments.model;

public class UPIDetails implements PaymentDetails {
	private String upiId ;
	private int otp ;
	private  int backedOTP = 0;
	public int getBackedOTP() {
		return backedOTP;
	}
	public void setBackedOTP(int backedOTP) {
		this.backedOTP = backedOTP;
	}
	public String getUpiId() {
		return upiId;
	}
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
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
