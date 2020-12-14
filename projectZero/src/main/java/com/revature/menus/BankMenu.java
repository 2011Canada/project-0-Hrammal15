//The controller takes user input and sends them to the service! ex userservice to verify login or register

package com.revature.menus;

import java.util.*;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.repositories.AccountDAO;
import com.revature.repositories.CustomerDAO;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.ICustomerDAO;
import com.revature.repositories.IEmployeeDAO;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;
import com.revature.services.CustomerServiceImplementation;
import com.revature.services.UserServiceImplementation;

public class BankMenu {
	UserServiceImplementation userService;
	CustomerServiceImplementation customerService;
	
	IUserDAO userDAO = new UserDAO();	
	IEmployeeDAO employeeDAO = new EmployeeDAO(); 
	AccountDAO accountDAO = new AccountDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	User u = new User();



	static Scanner sc = new Scanner(System.in);

	public BankMenu(UserServiceImplementation userService, CustomerServiceImplementation customerService) {
		this.userService = userService;
		this.customerService = customerService;
	}



	public void initialize() {
		userDisplay();
	}



	public void manageUserInput() {
		int initialInput = sc.nextInt();

		if (initialInput == 1) {
			userDisplay();

		} else if (initialInput == 2) {// customermenu
			customerDisplay();

		} else if (initialInput == 3) { // employeemenu
			employeeDisplay();
			employeeMenuChoice();

		} else if (initialInput == 0) { // exit
			System.out.println("Thanks for using my Bank System.");
			System.exit(0);

		} else {
			System.out.println("Plese enter a valid input");
		}
	}

	public void userDisplay() {// Displays menu for user
		System.out.println("Hello and Welcome to the Bank of Hassen\n"
				+ "Please press \n" + "1 - Login \n" + "2 - Exit");
		
		int input = sc.nextInt();

		if (input == 1) {
			login();

			System.out.println();
		} else if (input == 2) {
			System.out.println("Thanks for using Hassen' Bank");
			System.exit(0);
		} else {
			System.out.println("invalid input");
		}
	}
	
	public void login() { // user login menu
		Scanner us = new Scanner(System.in);
		String username, password;
		System.out.println("Please enter your username");// Take in user
		username = us.next();
		System.out.println("Please enter your password");// Take in pass
		password = us.next();
		User u = null;
		try {
		u = userService.login(username, password);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (InternalErrorException e) {
			e.printStackTrace();
		}
		System.out.println(u);
		System.out.println(u.getType());
		if(u.getType().equals("employee")){
			
			employeeDisplay();
			
			
		}else if(u.getType().equals("customer")){
			
			customerDisplayNoAccount();
			
			
		}else if(u.getType().equals("customerA")) {
			
			customerDisplay();
			
		}else if(u.getType().equals("user")) {
			
			userDisplayNoAccount();
		}
				

	}
	
	public void userDisplayNoAccount() {
		System.out.println("You are logged in as a user. Choose one of the following options\n"
				+ "1 - Create a CUSTOMER account\n"
				+ "2 - Exit\n");
		
		int input = sc.nextInt();
		
		if(input == 1) {
			register();
		}else {
			System.exit(0);
		}
		
	}

	public void register() { // user register menu
		String username, password, firstname, lastname;
		System.out.println("To register as a customer, please input the following\nPlease enter a Username");
		username = sc.next();
		System.out.println("\nPlease enter a password");
		password = sc.next();
		System.out.println("\nPlease enter your First name");
		firstname = sc.next();
		System.out.println("\nPlease enter your Last name");
		lastname = sc.next();
		try {
			
			userService.register(username, password, firstname, lastname);
		} catch (InvalidInputsExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InternalErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public User customerDisplayNoAccount() {
		System.out.println("To proceed, either create an Account or sign in as a customer with an account.\n"
				+ "Press the appropriate option\n" + "1 - Create An Account" + "\n2 - Sign in with a customer Account\n"
				+ "3 - exit");
		
		int input = sc.nextInt();

		if (input == 1) {
			customerService.applyForNewBank();
		} else if (input == 2) {
			login();
			System.out.println(u.getUsername());
			System.out.println(u.getType());
			
			
		} else if (input == 3) {
			System.exit(0);
		} else {
			System.out.println("Enter a valid input");
		}
		return u;
	}
	
	
	
	

	public void customerDisplay() {
		System.out.println("Please press\n" + "1 - View Balance Of My Account\n" + "2 - Withdrawal\n" + "3 - Deposit\n"
				+ "4 - Send A Transfer\n" + "5 - Accept A Transfer");
		int input = sc.nextInt();
		if (input == 1) {
		customerService.viewBalance();
		} else if (input == 2) {
		customerService.withdrawal();
		} else if (input == 3) {
		customerService.deposit();
		} else if (input == 4) {
			sendATransfer();
		} else if (input == 5) {
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





	public void employeeDisplay() {
		System.out.println("Please press\n" + "1 - View Pending Accounts\n" + "2 - View Customer Account\n"
				+ "3 - View All Transactions\n");

	}

	public void employeeMenuChoice() {
		int input = sc.nextInt();

		if (input == 1) {
			pendingAccounts();
		} else if (input == 2) {
			customerAcocunts();
		} else if (input == 3) {
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
