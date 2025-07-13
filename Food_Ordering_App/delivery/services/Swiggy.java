package com.aurionpro.delivery.services;

import com.aurionpro.delivery.model.IDelivery;

public class Swiggy implements IDelivery {

	@Override
	public boolean isAvailable() {
		return true;
	}

	@Override
	public String getName() {
		return "Swiggy";
	}

}
