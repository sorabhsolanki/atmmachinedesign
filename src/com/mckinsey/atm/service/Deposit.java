package com.mckinsey.atm.service;

import java.math.BigDecimal;

import com.mckinsey.atm.main.UserAccount;

/*
 * This class is responsible for deposit the requested amount into the user account.
 * 
 * This class is a prototype class.
 */
public class Deposit {

	final BigDecimal amount;
	
	public Deposit(BigDecimal amount){
		this.amount = amount;
	}
	
	public void deposit(UserAccount account){
		account.addAmount(amount);
	}
}
