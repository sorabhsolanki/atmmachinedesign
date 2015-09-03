package com.mckinsey.atm.service;

import java.math.BigDecimal;

import com.mckinsey.atm.exception.MachineOutOfOrderException;
import com.mckinsey.atm.exception.NotEnoughMoneyException;
import com.mckinsey.atm.lock.OperationLocks;
import com.mckinsey.atm.main.UserAccount;
import com.mckinsey.atm.validator.AtmMachineValidator;
import com.mckinsey.atm.validator.UserAccountValidator;

/*
 * This is an abstract class serving as a template pattern for OperationService class.
 */
public abstract class OperationServiceTemplate {

	public void withdrawOperation(UserAccount account, BigDecimal amount) throws NotEnoughMoneyException, MachineOutOfOrderException {
		// acquire lock
		OperationLocks.acquireLock();
		
		vlaidateAtmMachine();
		validateUserAccount(account);
		
		Withdraw withdraw = new Withdraw(amount);
		withdraw.withdraw(account);
		
		OperationLocks.releaseLock();
	}

	public void depositOperation(UserAccount account, BigDecimal amount) throws MachineOutOfOrderException, NotEnoughMoneyException {
		OperationLocks.acquireLock();
		
		vlaidateAtmMachine();
		validateUserAccount(account);
		
		Deposit deposit = new Deposit(amount);
		deposit.deposit(account);
		
		OperationLocks.releaseLock();
	}
	
	private void validateUserAccount(UserAccount account) throws NotEnoughMoneyException {
		UserAccountValidator accountValidator = UserAccountValidator.getInstance();
		accountValidator.validate(account);
	}

	private void vlaidateAtmMachine() {
		AtmMachineValidator atmMachineValidator = AtmMachineValidator.getInstance();
		atmMachineValidator.validate();
	}
}
