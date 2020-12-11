package com.revature.menus;

import java.util.Scanner;

import com.revature.services.UserService;

public class UserMenu {

	UserService userService;

	static Scanner sc = new Scanner(System.in);

	public UserMenu(UserService userService) {
		this.userService = userService;
	}

	public void initialize() {
		display();
		manageUserInput();
	}

	public void display() {
		System.out.println("Please press \n1 - Login \n2 - Create a customer account");
	}

	public void manageUserInput() {
		int input = sc.nextInt();

		if (input == 1) {
			login();
		} else if (input == 2) {
			register();
		} else {
			System.out.println("invalid input");
		}
	}

	public void login() {
		String username, password;
		System.out.println("Please enter your username");// Take in user
		username = sc.next();
		System.out.println("Please enter your password");// Take in pass
		password = sc.next();
		userService.login(username, password);// call userService pass them in

	}

	public void register() {
		String username,password,email;
		System.out.println("To register as a customer, please input the following\n Please enter a Username");
		username = sc.next();
		System.out.println("Please enter a password");
		password = sc.next();
		System.out.println("Please enter your email");
		email = sc.next();
		userService.register(username, password, email);
		
		
		
	}

}
