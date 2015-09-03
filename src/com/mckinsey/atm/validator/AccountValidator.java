package com.mckinsey.atm.validator;

import com.mckinsey.atm.exception.NotAnAuthorizedUserException;
import com.mckinsey.atm.exception.NotEnoughMoneyException;
import com.mckinsey.atm.main.UserAccount;

public interface AccountValidator extends Validator{

	public boolean validate(UserAccount account) throws NotEnoughMoneyException;
	
	public boolean validate(UserAccount account, Integer providedPin) throws NotAnAuthorizedUserException;
	
}
