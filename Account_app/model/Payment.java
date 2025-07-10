package com.aurionpro.payments.model;

import com.aurionpro.payments.account.model.Account;

public interface Payment {
	boolean pay(int ammount,Account sender, Account receivere);
    boolean validateDetails(PaymentDetails details);

}
