package com.mckinsey.atm.exception;

public class IllegalOperationException extends Exception{

	public IllegalOperationException(String message){
		super(message);
	}
	
	public IllegalOperationException(String message, Throwable cause){
		super(message, cause);
	}
}
