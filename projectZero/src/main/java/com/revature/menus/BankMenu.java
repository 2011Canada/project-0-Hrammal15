//The controller takes user input and sends them to the service! ex userservice to verify login or register

package com.revature.menus;

import java.util.*;

public class BankMenu {

	UserMenu userMenu;

	static Scanner sc = new Scanner(System.in);

	public BankMenu(UserMenu userMenu) {
		this.userMenu = userMenu;
	}

	public void initialize() {
		display();
		manageUserInput();
	}

	public void display() {
		System.out.println("Hello and Welcome to the Bank of Hassen \n"
				+ "Please input the appropriate number corresponding to you \n" + "1 - User\n"
				+ "2 - Registered Customer\n" + "3 - An employee\n" + "0 - Exit");
	}

	public void manageUserInput() {
		int initialInput = sc.nextInt();

		if (initialInput == 1) {
			userMenu.initialize();
		} else {
			System.out.println("Wrong input");
		}
	}

}
