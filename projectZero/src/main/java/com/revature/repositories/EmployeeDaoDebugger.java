package com.revature.repositories;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;

public class EmployeeDaoDebugger {

	public static void main(String[] args) throws UserNotFoundException, InternalErrorException {

		IEmployeeDAO cd = new EmployeeDAO();
		
		System.out.println(cd.findEmployeeByUsernameAndPassword("hrammal15", "password")); 
				
		
}
}