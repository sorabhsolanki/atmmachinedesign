package com.mckinsey.atm.exception;

public class NotAnAuthorizedUserException extends Exception{

	public NotAnAuthorizedUserException(String message){
		super(message);
	}
	
	public NotAnAuthorizedUserException(String message, Throwable cause){
		super(message, cause);
	}
}
