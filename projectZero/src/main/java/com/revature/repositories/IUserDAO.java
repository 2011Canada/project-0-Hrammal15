package com.revature.repositories;

import com.revature.models.User;

public interface IUserDAO {
	
	public User findUsername(User u);
	
	public User addAcount(User u);

}
