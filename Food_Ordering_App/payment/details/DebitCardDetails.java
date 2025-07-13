package com.aurionpro.payment.details;


public class DebitCardDetails{
	private String cvv ;
	private String Expiry ;
	private String cardnNumber ;
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpiry() {
		return Expiry;
	}
	public void setExpiry(String expiry) {
		Expiry = expiry;
	}
	public String getCardnNumber() {
		return cardnNumber;
	}
	public void setCardnNumber(String cardnNumber) {
		this.cardnNumber = cardnNumber;
	} 
}
