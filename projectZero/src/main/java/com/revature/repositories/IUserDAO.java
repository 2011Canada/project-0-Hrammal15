package com.revature.repositories;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface IUserDAO {
	
	public User findUserByUsername(String username) throws UserNotFoundException, InternalErrorException;
	
	public List<User> findAll();
	
}
