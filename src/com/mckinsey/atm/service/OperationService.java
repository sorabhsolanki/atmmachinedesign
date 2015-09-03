package com.mckinsey.atm.service;

import java.math.BigDecimal;

import com.mckinsey.atm.exception.MachineOutOfOrderException;
import com.mckinsey.atm.exception.NotEnoughMoneyException;
import com.mckinsey.atm.main.UserAccount;

/*
 * This class is responsible for user operations like withdraw and deposit.
 * 
 */
public class OperationService extends OperationServiceTemplate{
 
	@Override
	public void withdrawOperation(UserAccount account, BigDecimal amount) throws NotEnoughMoneyException, MachineOutOfOrderException {
		super.withdrawOperation(account, amount);
	}

	@Override
	public void depositOperation(UserAccount account, BigDecimal amount) throws MachineOutOfOrderException, NotEnoughMoneyException {
		super.depositOperation(account, amount);
	}
	
}
