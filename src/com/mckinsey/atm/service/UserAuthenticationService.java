package com.mckinsey.atm.service;

import com.mckinsey.atm.exception.NotAnAuthorizedUserException;
import com.mckinsey.atm.main.UserAccount;

/*
 * This class is responsible for authenticating the user.
 * 
 * Since this class does not contains any state, so it is a helper class containing static methods.
 */
public class UserAuthenticationService extends UserAuthenticationServiceTemplate{

	@Override
	public boolean authenticate(UserAccount account, Integer providedPin) throws NotAnAuthorizedUserException{
		return super.authenticate(account, providedPin);
	}
}
