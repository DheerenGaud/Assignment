package com.aurionpro.payments.model;

public class PaypalDetails implements PaymentDetails {
	private String email;
	private String token;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
