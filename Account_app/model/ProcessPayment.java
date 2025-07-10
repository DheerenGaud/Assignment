package com.aurionpro.payments.model;

import com.aurionpro.payments.account.model.Account;

public class ProcessPayment {
   public boolean paymentProcess(PaymentDetails detail,Payment paymentMethod,int amount,Account sender, Account recever) {
	    
	   if(paymentMethod.validateDetails(detail)) {
		   return  paymentMethod.pay(amount,sender,recever);
	   }
	   return false;
   }
}
