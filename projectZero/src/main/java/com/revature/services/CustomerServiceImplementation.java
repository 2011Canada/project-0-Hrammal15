package com.revature.services;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.BalanceBelowZeroException;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.launcher.ProjectZeroLauncher;
import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class CustomerServiceImplementation implements CustomerService {
	Scanner sc = new Scanner(System.in);

	IUserDAO userDAO = new UserDAO();
	User u;
	static User u3;
	public static Logger project0loggerTransactions = LogManager.getLogger("com.revature.project0HassenELTransactions");

	
	
	public void customerDisplay() {
		System.out.println("======================");
		System.out.println("Please press\n" + "1 - View Balance Of My Account\n" + "2 - Withdrawal\n" + "3 - Deposit\n"
				+ "4 - Send A Transfer\n" + "5 - Accept A Transfer");
		System.out.println("======================");

		int input = sc.nextInt();
		if (input == 1) {
			viewBalance();
		} else if (input == 2) {
			withdrawal();
		} else if (input == 3) {
			deposit();
		} else if (input == 4) {
			sendATransfer();
		} else if (input == 5) {
			acceptATransfer();
		} else {
			System.out.println("invalid input");
		}
	}

	public User applyForNewBank() {
		String username, password;
		Double balance;

		System.out.println("To apply for a new bank pleae enter the following for verification\n");
		
		System.out.println("Enter your username");
		username = sc.next();
		System.out.println("Enter your password");
		password = sc.next();
		System.out.println("Enter your initial balance amount");
		balance = sc.nextDouble();

		try {
			u = userDAO.findUserByUsernameAndPassword(username,password);
		} catch (UserNotFoundException e2) {
			e2.printStackTrace();
			customerDisplay();
		} catch (InternalErrorException e2) {
			e2.printStackTrace();
		}

		u.setType("customerA");
		try {
			userDAO.changeType(u);
		} catch (BalanceBelowZeroException e) {
			e.printStackTrace();
			applyForNewBank();
		} catch (InternalErrorException e) {
			e.printStackTrace();
		}
		u.setBalance(balance);
		try {
			userDAO.setBalance(u, balance);
		} catch (BalanceBelowZeroException e1) {
			e1.printStackTrace();
		} catch (InternalErrorException e1) {
			e1.printStackTrace();
		}

		System.out.println(u);
		project0loggerTransactions.debug(u.getUsername() + " Applied for a new bank  with an initial balance of = " + balance);


		return u;

	}

	public void viewBalance() {

		System.out.println("Enter your username of the account");
		String username = sc.next();

		try {
			u = userDAO.findUserByUsername(username);
		} catch (UserNotFoundException e2) {
			e2.printStackTrace();
		} catch (InternalErrorException e2) {
			e2.printStackTrace();
		}

		System.out.println("The balance for = " + u.getFirstName() + " " + u.getLastName() + " is : " + u.getBalance());
		project0loggerTransactions.debug(u.getUsername() + " viewed their balance ");

	}

	public void withdrawal() {
		System.out.println("Enter your username of the account");
		String username = sc.next();
		User u = null;

		try {
			u = userDAO.findUserByUsername(username);
		} catch (UserNotFoundException e2) {
			e2.printStackTrace();
			withdrawal();
		} catch (InternalErrorException e2) {
			e2.printStackTrace();
		}
		System.out.println(u);
		System.out.println("Your current balance is = " + u.getBalance() + " How much money would you like to withdrawal?\n" );
		Double withdrawalAmount = sc.nextDouble();
		boolean tf = true;
		Double newBalance = 0.0;
		
		while(tf) {
		if (withdrawalAmount > u.getBalance()) {
			System.out.println("Please enter a lower amount");
			 withdrawalAmount = sc.nextDouble();
			ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Just tried to withdrawal  " + withdrawalAmount + " from their account but was denied since it exceeded their balance" );
			project0loggerTransactions.debug(u.getUsername() + " Just tried to withdrawal  " + withdrawalAmount + " from their account but was denied since it exceeded their balance" );

		
		} else {
			
			newBalance = (u.getBalance() - withdrawalAmount);
			u.setBalance(newBalance);
			tf = false;
		}
		}
			try {
				userDAO.setBalance(u, newBalance);
			} catch (BalanceBelowZeroException e) {
				e.printStackTrace();
			} catch (InternalErrorException e) {
				e.printStackTrace();
			}
	
							
		ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Just withdrew " + withdrawalAmount + " from their account with a remaining balance of" + u.getBalance() );
		project0loggerTransactions.debug(u.getUsername() + " Just withdrew " + withdrawalAmount + " from their account with a remaining balance of" + u.getBalance() );

	}

	public void deposit() {
		System.out.println("Enter your username of the account");
		String username = sc.next();
		Double newbalance = 0.0;

		try {
			u = userDAO.findUserByUsername(username);
		} catch (UserNotFoundException e2) {
			e2.printStackTrace();
		} catch (InternalErrorException e2) {
			e2.printStackTrace();
		}
		System.out.println(u);
		System.out.println("How much money would you like to deposit?\n" + "Your current balance is = " + u.getBalance());
		Double depositAmount = sc.nextDouble();
		boolean tf = true;
		while(tf) {
		if(depositAmount < 0) {
			System.out.println("Please enter a valid amount to deposit");
			depositAmount = sc.nextDouble();
			ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Just tried to deposit  " + depositAmount + " from their account but was denied since it was an invalid balance" );
			project0loggerTransactions.debug(u.getUsername() + " Just tried to deposit  " + depositAmount + " from their account but was denied since it was an invalid balance" );

		}else {
			newbalance = (u.getBalance() + depositAmount);
			u.setBalance(newbalance);
			tf=false;
		}

		}try {
				userDAO.setBalance(u, newbalance);
		} catch (BalanceBelowZeroException e) {
			e.printStackTrace();
		} catch (InternalErrorException e) {
			e.printStackTrace();
		}
		try {
			u = userDAO.findUserByUsername(username);
		} catch (UserNotFoundException e2) {
			e2.printStackTrace();
		} catch (InternalErrorException e2) {
			e2.printStackTrace();
		}
		System.out.println(u);
		ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Just deposited " + depositAmount + " Into their account" );
		project0loggerTransactions.debug(u.getUsername() + " Just deposited " + depositAmount + " Into their account" );


	}
	
	public void sendATransfer() {
		User u = null;
		String username,password;
		System.out.println("Before we proceed, for security reasons please enter the follow.\n\n");
		System.out.println("Please enter your username");
		username = sc.next();
		System.out.println("Please enter your password");
		password = sc.next();
		
		try {
			u = userDAO.findUserByUsernameAndPassword(username, password);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (InternalErrorException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\nWho would you like to send money to");
		String type = sc.next();
		
		
		try {
			u3 = userDAO.findUserByUsername(type);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InternalErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		System.out.println("Your current balance is = " + u.getBalance() + ". How much money would you like to send?\n" );
		Double moneySent = sc.nextDouble();
		boolean tf = true;
		Double newBalance = 0.0;
		
		while(tf) {
		if (moneySent > u.getBalance()) {
			System.out.println("Please enter a lower amount");
			moneySent = sc.nextDouble();
			ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Just tried to post  " + moneySent + " from their account but was denied since it exceeded their balance" );
		
		} else {
			
			newBalance = (u.getBalance() - moneySent);
			u.setBalance(newBalance);
			tf = false;
		}
		}
			try {
				userDAO.setBalance(u, newBalance);
			} catch (BalanceBelowZeroException e) {
				e.printStackTrace();
			} catch (InternalErrorException e) {
				e.printStackTrace();
			}

					
		ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Just sent " + moneySent + " from their account to user " + type + " with a remaining balance of = " + u.getBalance());
		project0loggerTransactions.debug(u.getUsername() + " Just sent " + moneySent + " from their account to user " + type + " with a remaining balance of = " + u.getBalance());

		String originalSender = u.getUsername();
		try {
			userDAO.setTransfer(originalSender,type, moneySent);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (InternalErrorException e) {
			e.printStackTrace();
		}

		System.out.println("MONEY SENT TO " + type + " AMOUNT SENT IS " + moneySent + " -- IN PENDING STATE!");

	}

	
	
	public void acceptATransfer() {
		String username,password;
		String username2 = "transfer";
		User u = null;
		User u2 = null;
		System.out.println("To accept a transfer please sign in");
		System.out.println("Please enter your username");
		username = sc.next();
		System.out.println("Please enter your password");
		password = sc.next();	
		
		
		try {
			u = userDAO.findUserByUsernameAndPassword(username, password);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			acceptATransfer();
		} catch (InternalErrorException e) {
			e.printStackTrace();
		}
		
		try {
			u2 = userDAO.findUserByUsername(username2);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			acceptATransfer();
		} catch (InternalErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("You received a transfer with amount " + u2.getBalance()
					+ " Would you like to accept?\n1 - to ACCEPT\n2 - to REJECT");
		int choice = sc.nextInt();
		System.out.println(u);

		if(choice == 1) {
			if(u.getUsername().equals(u2.getType())) {
				
				Double balance = u2.getBalance();
				

				try {
					Double newbalance = (u.getBalance() + balance);
					u.setBalance(newbalance);
					userDAO.setBalance(u, newbalance);
				} catch (BalanceBelowZeroException e) {
					e.printStackTrace();
				} catch (InternalErrorException e) {
					e.printStackTrace();
				}
				try {
					u = userDAO.findUserByUsername(username);
				} catch (UserNotFoundException e2) {
					e2.printStackTrace();
				} catch (InternalErrorException e2) {
					e2.printStackTrace();
				}
				System.out.println(u);
				ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Just deposited " + balance + " Into their account" );
				project0loggerTransactions.debug(u.getUsername() + " Just deposited " + balance + " Into their account" );




			}else {
				System.out.println("No pending transfers for you");
				customerDisplay();
			}

			
		}else if(choice == 2) {
			System.out.println("You rejected the transfer, transfer goes back to original owner.");
			
			Double balance = (u2.getBalance() + u.getBalance());
			String originalSender = u.getStatus();
			try {
				Double newbalance = (u.getBalance() + balance);
				userDAO.rejectBalance(originalSender, newbalance);
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			} catch (InternalErrorException e) {
				e.printStackTrace();
			}
			try {
				u = userDAO.findUserByUsername(username);
			} catch (UserNotFoundException e2) {
				e2.printStackTrace();
			} catch (InternalErrorException e2) {
				e2.printStackTrace();
			}
			System.out.println(u);
			ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Just REJECTED " + balance + ". Money was returned to sender" );
			project0loggerTransactions.debug(u.getUsername() + " Just REJECTED " + balance + ". Money was returned to sender" );


			
		}else {
			System.out.println("Invalid entry. Try again.");
			acceptATransfer();
		}


	}



}
