package com.revature.menus;
import java.util.Scanner;
import com.revature.models.User;
 

public class ControllerUser extends User {

	Scanner sc = new Scanner(System.in);

	ControllerUser(String userFirstName, String userFastName, String userEmail, String userPhoneNumer) {
		super(userFirstName, userFastName, userEmail, userPhoneNumer);
	}

	//System controller
	public void userOptions() {
	System.out.println(" 1 - Login as a User \n 2 - Register an account");
	
	}
	
	
	

}
