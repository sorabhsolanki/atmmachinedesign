package com.mckinsey.atm.validator;


/*
 * This class is  responsible for validating the ATM machine like it contains the amount which
 * user has requested for withdraw.
 * 
 * This class is a singleton class
 */
public class AtmMachineValidator implements Validator{

	private static AtmMachineValidator atmMachineValidator = null;
	
	private AtmMachineValidator(){}
	
	public static AtmMachineValidator getInstance(){
		if(atmMachineValidator == null){
			synchronized (AtmMachineValidator.class) {
				if(atmMachineValidator == null){
					atmMachineValidator = new AtmMachineValidator();
				}
			}
		}
		return atmMachineValidator;
	}

	@Override
	public boolean validate() {
		return true;
	}

}
