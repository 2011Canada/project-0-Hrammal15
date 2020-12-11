//The controller takes user input and sends them to the service! ex userservice to verify login or register

package com.revature.menus;
import java.util.*;

import com.revature.models.Displayable;
import com.revature.services.UserService;

public class BankMenu implements Displayable{
	
	static Scanner sc = new Scanner(System.in);

	
	
	public static void manageUserInput() {
		System.out.println("Hello and Welcome to the Bank of Hassen \n"
				+ "Please input the appropriate number corresponding to you \n"
				+ "1 - User\n"
				+ "2 - Registered Customer\n"
				+ "3 - An employee\n"
				+ "0 - Exit");
		int initialInput = sc.nextInt();
		
	}



	public String display() {
		// TODO Auto-generated method stub
		return null;
	}
	}
	
