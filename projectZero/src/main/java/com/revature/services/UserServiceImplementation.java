package com.revature.services;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.IUserDAO;

public class UserServiceImplementation implements UserService {
	
	IUserDAO userDAO;
	User u;
	
	public UserServiceImplementation() {
		this.userDAO = userDAO;
		this.u = u;
	}
	


	public User login(String username, String password) throws UserNotFoundException, InternalErrorException {
		System.out.println("Test");
		userDAO.findUserByUsername(username);
		if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
			System.out.println(u);
			return u;
		}else {
			throw new UserNotFoundException();
			
		}
			
		};
				

			
	public void register(String username, String password, String firstname, String lastname) {
		
	}


}
