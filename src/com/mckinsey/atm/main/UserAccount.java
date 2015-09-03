package com.mckinsey.atm.main;

import java.math.BigDecimal;

/*
 * Class responsible for UserAccount.
 * 
 * It is a singleton class.
 */
public class UserAccount {

	private BigDecimal accountBalace;
	private Integer pin;
	
	public UserAccount(BigDecimal accountBalace, Integer pin){
		this.accountBalace = accountBalace;
		this.pin = pin;
	}
	
	//copy constructor
	public UserAccount(UserAccount account){
		this.accountBalace = account.getBalance();
		this.pin = account.getPin();
	}
	
	
	public void setInitialBalance(BigDecimal accountBalace){
		this.accountBalace = accountBalace;
	}
	
	public void setInitialBalance(BigDecimal accountBalace, Integer pin){
		this.accountBalace = accountBalace;
		this.pin = pin;
	}
	
	public BigDecimal addAmount(BigDecimal amount){
		this.accountBalace = this.accountBalace.add(amount);
		return accountBalace;
	}
	
	public BigDecimal subtractAmount(BigDecimal amount){
		this.accountBalace = this.accountBalace.subtract(amount);
		return accountBalace;
	}
	
	public BigDecimal getBalance(){
		return accountBalace;
	}
	
	public void setPin(){
		this.pin = pin;
	}
	
	public Integer getPin(){
		return pin;
	}
	
	@Override
	public String toString(){
		return "Your account Balance is:" + accountBalace;
	}
}
