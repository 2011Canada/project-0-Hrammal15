package com.revature.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.menus.BankMenu;

import com.revature.services.CustomerServiceImplementation;
import com.revature.services.EmployeeServicesImplementation;
import com.revature.services.UserServiceImplementation;

public class ProjectZeroLauncher {

	public static Logger project0logger = LogManager.getLogger("com.revature.project0HassenEL");

	public static void main(String[] args) {

		UserServiceImplementation userService = new UserServiceImplementation();
		CustomerServiceImplementation customerService = new CustomerServiceImplementation();
		EmployeeServicesImplementation employeeService = new EmployeeServicesImplementation();

		project0logger.info("Server has started");

		BankMenu bankMenu = new BankMenu(userService, customerService, employeeService);

		while (true) {
			bankMenu.userDisplay();
		}
	}

}

//fix logging 
// fix exceptions
//make pending user account to customers able to proceed or not