package com.revature.models;

public class Customer {

	String customerFirstName;
	String customerLastName;
	String customerPassword;
	int customerBalance;
	int customerId;
	
	
	Customer(String customerFirstName, String customerLastName, String customerPassword, int customerBalance, int customerId){
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerPassword = customerPassword;
		this.customerBalance = customerBalance;
		this.customerId = customerId;
	}
	
	public void applyNewBankAccount() {
		
	}
	
	public int viewBalance(int customerBalance) {
		
		return customerBalance;
	}
	
	public void customerWithdraw() {
		
		
	}
	
	public void customerDeposite() {
		
	}
	
	public void sendMoneyTransfer() {
		
	}
	
	public void receiveMoneyTransfer() {
		
	}
	
}
