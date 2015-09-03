package com.mckinsey.atm.service;

import java.math.BigDecimal;

import com.mckinsey.atm.main.UserAccount;

/*
 * This class is responsible for withdraw the requested amount from user account.
 * 
 * This class is a prototype class.
 */
public class Withdraw {


	final BigDecimal amount;
	
	public Withdraw(BigDecimal amount){
		this.amount = amount;
	}
	
	public void withdraw(UserAccount account){
		account.subtractAmount(amount);
	}
}
