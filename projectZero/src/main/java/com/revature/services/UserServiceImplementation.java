package com.revature.services;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class UserServiceImplementation implements UserService {
	
	IUserDAO ud = new UserDAO();


	public void login(String username, String password) throws UserNotFoundException, InternalErrorException{
		if(ud.findUserByUsernameAndPassword(username, password.equals(username,password){
			
		});
				

	}
			
	public void register(String username, String password, String firstname, String lastname) {
		
	}


}
