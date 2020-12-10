//The controller takes user input and sends them to the service! ex userservice to verify login or register

package com.revature.menus;
import java.util.*;

import com.revature.services.UserService;

public class AuthenticationController {
	
	static Scanner sc = new Scanner(System.in);

	public static void initializer() {
		System.out.println("Hello and Welcome to the Bank of Hassen \n"
				+ "Please input the appropriate number corresponding to you \n"
				+ "1 - User\n"
				+ "2 - Registered Customer\n"
				+ "3 - An employee\n"
				+ "0 - Exit");
		int initialInput = sc.nextInt();
	
	
	if(initialInput == 1) {
		
		System.out.println("Welcome to Bank of Hassen, as a User you get 2 options\n"
				+ "Please input the appropriate number corresponding to you\n"
				+ "1 - To sign in\n"
				+ "2 - To create an account");
		int userInput = sc.nextInt();
		
		if(userInput == 1) {//if user has a login, this is where we take username and password for logging in
			String username;
			String password;
			
			System.out.println("Please enter the following to sign in \n");
			System.out.println("Input your username \n");
			username = sc.nextLine();
			System.out.println("Input your password \n");
			password = sc.nextLine();
			UserService.login(username,password); //sends username and password to userservice

					
			
		}else {
			System.out.println("Create account method");
		}

	}else {
		System.out.println("testing");
	}
	
	}}
