package com.mckinsey.atm.service;

import com.mckinsey.atm.exception.NotAnAuthorizedUserException;
import com.mckinsey.atm.main.UserAccount;
import com.mckinsey.atm.validator.AtmMachineValidator;
import com.mckinsey.atm.validator.UserAccountValidator;

/*
 * This is an abstract class serving as a template pattern for UserAuthenticationService class.
 */
public abstract class UserAuthenticationServiceTemplate {

	public boolean authenticate(UserAccount account, Integer providedPin) throws NotAnAuthorizedUserException{
		vlaidateAtmMachine();
		validateUserAccount(account, providedPin);
		return true;
	}

	private void validateUserAccount(UserAccount account, Integer providedPin) throws NotAnAuthorizedUserException {
		UserAccountValidator accountValidator = UserAccountValidator.getInstance();
		accountValidator.validate(account, providedPin);
	}

	private void vlaidateAtmMachine() {
		AtmMachineValidator atmMachineValidator = AtmMachineValidator.getInstance();
		atmMachineValidator.validate();
	}
}
