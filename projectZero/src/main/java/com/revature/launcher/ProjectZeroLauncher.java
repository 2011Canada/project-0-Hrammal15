package com.revature.launcher;
import java.util.*;

// the logic should be in the service layer and the data that you will be checking against has to come from the repository
import com.revature.menus.ControllerEmployee;

public class ProjectZeroLauncher {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello and Welcome to the Bank of Hassen \n"
				+ "Please input the appropriate number corresponding to you \n"
				+ "1 - User\n"
				+ "2 - Registered Customer\n"
				+ "3 - An employee\n"
				+ "0 - Exit");
		
		int consoleInput = sc.nextInt();
		
		
			if(consoleInput == 1) {
				
			
			}else if(consoleInput == 2) {
				
				
				
				
			
			}else if(consoleInput == 3) {
				
				
				ControllerEmployee.loginEmployee();
				ControllerEmployee.checkValidation();

				
			
			}else if (consoleInput == 0) {
				System.out.println("Thank you for using our Bank! Please come again.");
				
				
				
				
			}else {
				System.out.println("Invalid input. Please try again.");
		}

	}

}
