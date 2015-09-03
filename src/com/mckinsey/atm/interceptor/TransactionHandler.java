package com.mckinsey.atm.interceptor;

import com.mckinsey.atm.main.UserAccount;

/*
 * This class is responsible for handling the transaction. 
 * It will be use to demarkation of transaction start and stop.
 * 
 * It make use of state pattern.
 */
public class TransactionHandler {

	UserAccount account;
	
	public TransactionHandler(UserAccount account){
		account = new UserAccount(account);
	}

	public UserAccount getAccount() {
		return account;
	}
	
}
