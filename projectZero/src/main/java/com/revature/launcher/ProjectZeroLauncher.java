package com.revature.launcher;
import java.util.*;
// the logic should be in the service layer and the data that you will be checking against has to come from the repository
import com.revature.menus.BankMenu;
import com.revature.menus.UserMenu;
import com.revature.services.UserService;
import com.revature.services.UserServiceImplementation;

public class ProjectZeroLauncher {
	
	public static void main(String[] args) {
		
		UserService userService  = new UserServiceImplementation();
		UserMenu userMenu = new UserMenu(userService);
		BankMenu bankMenu = new BankMenu(userMenu);
		bankMenu.initialize();
		
		
//	while(true) {
//		System.out.println(hbs.display);
//		hbs.manageUserInput();
		
		
//	}
				
				
				
		

	}

}
