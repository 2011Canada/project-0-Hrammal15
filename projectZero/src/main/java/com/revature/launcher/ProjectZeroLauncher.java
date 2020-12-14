package com.revature.launcher;
import com.revature.menus.BankMenu;
import com.revature.services.CustomerServiceImplementation;
import com.revature.services.UserServiceImplementation;

public class ProjectZeroLauncher {
	
	public static void main(String[] args) {
		
		UserServiceImplementation userService = new UserServiceImplementation();
		CustomerServiceImplementation customerService = new CustomerServiceImplementation();
		BankMenu bankMenu = new BankMenu(userService, customerService);
		

	while(true) {
		
		bankMenu.initialize();

		
	}

				
				
		

	}

}
