package com.mckinsey.atm.validator;

import com.mckinsey.atm.exception.NotAnAuthorizedUserException;
import com.mckinsey.atm.exception.NotEnoughMoneyException;
import com.mckinsey.atm.main.UserAccount;

/*
 * This class is  responsible for validating the user account.
 * 
 * This class is a singleton class
 */
public class UserAccountValidator implements AccountValidator{

    private static UserAccountValidator userAccountValidator = null;
	
	private UserAccountValidator(){}
	
	public static UserAccountValidator getInstance(){
		if(userAccountValidator == null){
			synchronized (UserAccountValidator.class) {
				if(userAccountValidator == null){
					userAccountValidator = new UserAccountValidator();
				}
			}
		}
		return userAccountValidator;
	}

	@Override
	public boolean validate(UserAccount account) throws NotEnoughMoneyException{
		return true;
	}

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public boolean validate(UserAccount account, Integer providedPin) throws NotAnAuthorizedUserException {
		return true;
	}

	

	
}
