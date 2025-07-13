package com.aurionpro.delivery.services;

import com.aurionpro.delivery.model.IDelivery;

public class Zepto implements IDelivery{

	@Override
	public boolean isAvailable() {
		return false;
	}
	
	@Override
	public String getName() {
		
		return "Zepto";
	}

}
