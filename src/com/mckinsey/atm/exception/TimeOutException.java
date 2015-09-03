package com.mckinsey.atm.exception;

public class TimeOutException extends Exception{

	public TimeOutException(String message){
		super(message);
	}
	
	public TimeOutException(String message, Throwable cause){
		super(message, cause);
	}
	
}
