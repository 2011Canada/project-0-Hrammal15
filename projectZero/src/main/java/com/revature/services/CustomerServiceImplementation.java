package com.revature.services;

import java.util.Scanner;

import com.revature.exceptions.BalanceBelowZeroException;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.menus.BankMenu;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.repositories.AccountDAO;
import com.revature.repositories.CustomerDAO;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.IAccountDAO;
import com.revature.repositories.ICustomerDAO;
import com.revature.repositories.IEmployeeDAO;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class CustomerServiceImplementation implements CustomerService {
	Scanner sc = new Scanner(System.in);

	IUserDAO userDAO = new UserDAO();
	ICustomerDAO customerDAO = new CustomerDAO();
	IAccountDAO accountDAO = new AccountDAO();
	User u;

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
			u = userDAO.findUserByUsername(username);
		} catch (UserNotFoundException e2) {
			e2.printStackTrace();
		} catch (InternalErrorException e2) {
			e2.printStackTrace();
		}

		u.setType("customerA");
		try {
			userDAO.changeType(u);
		} catch (BalanceBelowZeroException e) {
			e.printStackTrace();
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

	}

	public void withdrawal() {
		System.out.println("Enter your username of the account");
		String username = sc.next();
		User u = null;

		try {
			u = userDAO.findUserByUsername(username);
		} catch (UserNotFoundException e2) {
			e2.printStackTrace();
		} catch (InternalErrorException e2) {
			e2.printStackTrace();
		}
		System.out.println(u);
		System.out.println(
				"How much money would you like to withdrawal?\n" + "Your current balance is = " + u.getBalance());
		Double withdrawalAmount = sc.nextDouble();

		if (withdrawalAmount > u.getBalance()) {
			System.out.println("Please enter a lower amount");
		} else {
			try {
				Double newbalance = (u.getBalance() - withdrawalAmount);
				u = userDAO.setBalance(u, newbalance);
			} catch (BalanceBelowZeroException e) {
				e.printStackTrace();
			} catch (InternalErrorException e) {
				e.printStackTrace();
			}
		}
		try {
			u = userDAO.findUserByUsername(username);
		} catch (UserNotFoundException e2) {
			e2.printStackTrace();
		} catch (InternalErrorException e2) {
			e2.printStackTrace();
		}
		System.out.println(u);

	}

	public void deposit() {
		System.out.println("Enter your username of the account");
		String username = sc.next();

		try {
			u = userDAO.findUserByUsername(username);
		} catch (UserNotFoundException e2) {
			e2.printStackTrace();
		} catch (InternalErrorException e2) {
			e2.printStackTrace();
		}
		System.out.println(u);
		System.out
				.println("How much money would you like to deposit?\n" + "Your current balance is = " + u.getBalance());
		Double depositAmount = sc.nextDouble();

		try {
			Double newbalance = (u.getBalance() + depositAmount);
			u = userDAO.setBalance(u, newbalance);
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

	}

}
