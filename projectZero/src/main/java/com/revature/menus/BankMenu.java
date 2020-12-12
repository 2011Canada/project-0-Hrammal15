//The controller takes user input and sends them to the service! ex userservice to verify login or register

package com.revature.menus;

import java.util.*;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.services.UserServiceImplementation;

public class BankMenu{
	UserServiceImplementation userService;
	


	static Scanner sc = new Scanner(System.in);



	public void initialize(){
		display();
		manageUserInput();
	}

	public void display() {
		System.out.println("Hello and Welcome to the Bank of Hassen \n"
				+ "Please input the appropriate number corresponding to you \n" + "1 - User\n"
				+ "2 - Registered Customer\n" + "3 - An employee\n" + "0 - Exit");
	}

	
	
	
	public void manageUserInput(){
		int initialInput = sc.nextInt();

		if (initialInput == 1) {
			userDisplay();
			userMenuChoice();	
		}else if(initialInput == 2) {//customermenu
			customerDisplay();
			customerMenuChoice();

			
		}else if(initialInput == 3) { //employeemenu
			employeeDisplay();
			employeeMenuChoice();

		}else{
			System.out.println("Plese enter a valid input");
		}
	}	

	
	public void userDisplay() {//Displays menu for user 
		System.out.println("Please press \n"
				+ "1 - Login \n"
				+ "2 - Create a customer account");
	}

	public void userMenuChoice() {
		int input = sc.nextInt();

		if (input == 1) {
			login();
		} else if (input == 2) {
			register();
		} else {
			System.out.println("invalid input");
		}
	}

	public void login() { //user login menu
		Scanner us = new Scanner(System.in);
		String username, password;
		System.out.println("Please enter your username");// Take in user
		username = us.next();
		System.out.println("Please enter your password");// Take in pass
		password = us.next();
		try {
			userService.login(username, password);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (InternalErrorException e) {
			e.printStackTrace();
		}

	}

	public void register() { // user register menu
		String username,password,firstname,lastname;
		System.out.println("To register as a customer, please input the following\n Please enter a Username");
		username = sc.next();
		System.out.println("Please enter a password");
		password = sc.next();
		System.out.println("Please enter your First name");
		firstname = sc.next();
		System.out.println("Please enter your Last name");
		lastname = sc.next();
		userService.register(username, password, firstname, lastname);
		
	}
	
	
	public void customerDisplay() {
		System.out.println("Please press\n1 - Apply For A New Bank\n"
				+ "2 - View Balance Of My Account\n"
				+ "3 - Withdrawal\n"
				+ "4 - Deposit\n"
				+ "5 - Send A Transfer "
				+ "6 - Accept A Transfer");
	}
	
	public void customerMenuChoice() {
		int input = sc.nextInt();

		if (input == 1) {
			applyForNewBank();
		} else if (input == 2) {
			viewBalance();
		}else if (input == 3) {
			withdrawal();
		}else if (input == 4) {
			deposit();
		}else if (input == 5) {
			sendATransfer();
		}else if (input == 6) {
			acceptATransfer();
		} else {
			System.out.println("invalid input");
		}
	}

	private void acceptATransfer() {
		// TODO Auto-generated method stub
		System.out.println("Accept transfer");
		
	}

	private void sendATransfer() {
		// TODO Auto-generated method stub
		System.out.println("send transfer");

	}

	private void deposit() {
		// TODO Auto-generated method stub
		System.out.println("Deposit");

	}

	private void withdrawal() {
		// TODO Auto-generated method stub
		System.out.println("withdrawal ");

	}

	private void viewBalance() {
		// TODO Auto-generated method stub
		System.out.println("View balance ");

	}

	private void applyForNewBank() {
		// TODO Auto-generated method stub
		System.out.println("Apply for new Bank ");

	}
	
	public void employeeDisplay() {
		System.out.println("Please press\n"
				+ "1 - View Pending Accounts\n"
				+ "2 - View Customer Account\n"
				+ "3 - View All Transactions\n");

	}
	
	public void employeeMenuChoice() {
		int input = sc.nextInt();

		if (input == 1) {
			pendingAccounts();
		} else if (input == 2) {
			customerAcocunts();
		}else if (input == 3) {
			transactions();
		} else {
			System.out.println("invalid input");
		}
	}

	private void transactions() {
		System.out.println("Transction");		
	}

	private void customerAcocunts() {
		System.out.println("customer accounts");		
		
	}

	private void pendingAccounts() {
		System.out.println("pending accounts");		
		
	}

	

}
