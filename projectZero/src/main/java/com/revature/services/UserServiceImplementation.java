package com.revature.services;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.launcher.ProjectZeroLauncher;
import com.revature.models.User;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.IEmployeeDAO;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class UserServiceImplementation implements UserService {
	
	IUserDAO userDAO = new UserDAO();	
	IEmployeeDAO employeeDAO = new EmployeeDAO(); 
	


	

	public User login(String username, String password) throws UserNotFoundException, InternalErrorException {
		User u = userDAO.findUserByUsernameAndPassword(username,password);
		
		if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
			return u;
		}
		ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Just logged in");
		return u;


	}		
			
	public User register(String username, String password, String firstname, String lastname) throws InvalidInputsExeption, InternalErrorException {
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setFirstName(firstname);
		u.setLastName(lastname);
		userDAO.newAccount(u);
		ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Account was just created as a " + u.getType());
		return u;
	}


}
