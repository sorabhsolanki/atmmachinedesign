package com.mckinsey.atm.exception;

public class NotEnoughMoneyException extends Exception{

	public NotEnoughMoneyException(String message){
		super(message);
	}
	
	public NotEnoughMoneyException(String message, Throwable cause){
		super(message, cause);
	}
	
}
