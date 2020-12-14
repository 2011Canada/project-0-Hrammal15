package com.revature.services;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.menus.BankMenu;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.repositories.CustomerDAO;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.ICustomerDAO;
import com.revature.repositories.IEmployeeDAO;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class UserServiceImplementation implements UserService {
	
	IUserDAO userDAO = new UserDAO();	
	ICustomerDAO customerDAO = new CustomerDAO();
	IEmployeeDAO employeeDAO = new EmployeeDAO(); 
	


	public User login(String username, String password) throws UserNotFoundException, InternalErrorException {
		User u = userDAO.findUserByUsername(username);
		
		if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
			return u;
		}
		return u;

	}		
			
	public User register(String username, String password, String firstname, String lastname) throws InvalidInputsExeption, InternalErrorException {
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setFirstName(firstname);
		u.setLastName(lastname);
		userDAO.newAccount(u);
		return u;
	}


}
