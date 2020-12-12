package com.revature.services;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserService {
	
	public User login(String username, String password) throws UserNotFoundException, InternalErrorException;
	
	public void register(String username, String password, String firstname, String lastname );

}
