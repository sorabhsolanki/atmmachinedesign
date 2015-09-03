package com.mckinsey.atm.controller;

import java.math.BigDecimal;

import com.mckinsey.atm.exception.MachineOutOfOrderException;
import com.mckinsey.atm.exception.NotAnAuthorizedUserException;
import com.mckinsey.atm.exception.NotEnoughMoneyException;
import com.mckinsey.atm.main.UserAccount;
import com.mckinsey.atm.service.OperationService;
import com.mckinsey.atm.service.UserAuthenticationService;
import com.mckinsey.atm.util.OperationEnum;

/*
 * This is front end class responsible for user request handling.
 * 
 *  It is based upon Facade design pattern.
 */
public class AtmController {
 
	private static AtmController CONTROLLER = null;
	private final UserAccount account;
	
	private AtmController(UserAccount account){
		this.account = account;
	}
	
	public static AtmController getInstance(UserAccount account){
		if(CONTROLLER == null){
			synchronized (AtmController.class) {
				if(CONTROLLER == null){
					CONTROLLER = new AtmController(account);
				}
			}
		}
		return CONTROLLER;
	}
	
	public boolean authorizeUserDetails() throws NotAnAuthorizedUserException{
		UserAuthenticationService authenticationService = new UserAuthenticationService();
		authenticationService.authenticate(account, account.getPin());
		return true;
	}
	
	public void doOeration(OperationEnum operation, BigDecimal amount) throws NotEnoughMoneyException, MachineOutOfOrderException{
		OperationService operationService = new OperationService();
		if(operation.equals(OperationEnum.WITHDRAW))
			operationService.withdrawOperation(account, amount);
		else if(operation.equals(OperationEnum.DEPOSIT))
			operationService.depositOperation(account, amount);
	}

	public UserAccount getAccount() {
		return account;
	}
	
	
	
}
