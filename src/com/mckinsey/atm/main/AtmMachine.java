package com.mckinsey.atm.main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

import com.mckinsey.atm.controller.AtmController;
import com.mckinsey.atm.exception.MachineOutOfOrderException;
import com.mckinsey.atm.exception.NotAnAuthorizedUserException;
import com.mckinsey.atm.exception.NotEnoughMoneyException;
import com.mckinsey.atm.exception.TimeOutException;
import com.mckinsey.atm.interceptor.SessionHandler;
import com.mckinsey.atm.interceptor.TransactionHandler;
import com.mckinsey.atm.util.OperationEnum;

/*
 * Main class for running the simulation.
 */
public class AtmMachine {

	private AtmController atmController;
	private SessionHandler sessionHandler = new SessionHandler();
	private UserAccount account;

	public AtmMachine() {
		
	}

	private void setUpAccount() {
		this.account = new UserAccount(new BigDecimal(300), 1234);
		atmController = AtmController.getInstance(account);
	}

	private void insertCard() throws TimeOutException,
			NotAnAuthorizedUserException {
		sessionHandler.startTimer();
		System.out.println("Insert Card: \n Type any word");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		if (sessionHandler.isTimeOut())
			throw new TimeOutException("time out");
		atmController = AtmController.getInstance(this.getAccount());
		atmController.authorizeUserDetails();
	}

	private void insertPin() throws TimeOutException,
			NotAnAuthorizedUserException {
		sessionHandler.setStartOperation(true);
		System.out.println("Insert pin");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		if (sessionHandler.isTimeOut())
			throw new TimeOutException("time out");
		atmController.authorizeUserDetails();
	}

	private void operation(OperationEnum operation) {
		if (operation.equals(OperationEnum.WITHDRAW)) {
			TransactionHandler handler = new TransactionHandler(this.account);
			try {
				sessionHandler.setStartOperation(true);
				System.out.println("Insert amonut for withdraw ");
				Scanner scanner = new Scanner(System.in);
				String amount = scanner.nextLine();
				if (sessionHandler.isTimeOut())
					throw new TimeOutException("time out");
				atmController.doOeration(operation, new BigDecimal(amount));
			} catch (TimeOutException | NotEnoughMoneyException	| MachineOutOfOrderException ex) {
				this.account = handler.getAccount();
			}
		} else if (operation.equals(OperationEnum.DEPOSIT)) {
			TransactionHandler handler = new TransactionHandler(this.account);
			try {
				sessionHandler.setStartOperation(true);
				System.out.println("Insert amonut for deposit ");
				Scanner scanner = new Scanner(System.in);
				String amount = scanner.nextLine();
				if (sessionHandler.isTimeOut())
					throw new TimeOutException("time out");
				atmController.doOeration(operation, new BigDecimal(amount));
			} catch (TimeOutException | NotEnoughMoneyException | MachineOutOfOrderException ex) {
				this.account = handler.getAccount();
			}
		}
	}

	private void operationCompleted() {
		System.out.println("Thanks for visiting...");
		sessionHandler.interrupt();
	}
	

	public UserAccount getAccount() {
		return account;
	}

	public static void main(String[] args) throws TimeOutException,	NotAnAuthorizedUserException, NotEnoughMoneyException,
			MachineOutOfOrderException {
		
		AtmMachine atmMachine = new AtmMachine();
		atmMachine.setUpAccount();
		atmMachine.insertCard();
		atmMachine.insertPin();
		atmMachine.operation(OperationEnum.WITHDRAW);
		atmMachine.operationCompleted();
		System.out.println(atmMachine.getAccount());
	}
}
