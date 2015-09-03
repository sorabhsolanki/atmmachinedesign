package com.mckinsey.atm.exception;

public class MachineOutOfOrderException extends Exception{

	public MachineOutOfOrderException(String message){
		super(message);
	}
	
	public MachineOutOfOrderException(String message, Throwable cause){
		super(message, cause);
	}
}
