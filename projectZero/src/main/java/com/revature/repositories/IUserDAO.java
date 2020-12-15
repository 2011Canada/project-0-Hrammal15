package com.revature.repositories;
import java.util.List;

import com.revature.exceptions.BalanceBelowZeroException;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface IUserDAO {
	
	public User findUserByUsername(String username) throws UserNotFoundException, InternalErrorException;
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException;
	
	public User changeType(User u) throws BalanceBelowZeroException, InternalErrorException;
	
	public User setBalance(User u , Double balance ) throws BalanceBelowZeroException, InternalErrorException;
	
	public User rejectBalance(String status , Double balance ) throws UserNotFoundException, InternalErrorException;
	
	public User newAccount(User u) throws InvalidInputsExeption, InternalErrorException;
	
	public User changeStatusDenied(User u) throws UserNotFoundException, InternalErrorException;
	
	public User changeStatusActive(User u) throws UserNotFoundException, InternalErrorException;
	
	public User getType(String username) throws UserNotFoundException, InternalErrorException;
	
	public void setTransfer(String originalSender, String type,Double balance) throws UserNotFoundException, InternalErrorException;
	
	
	//public List<User> findAll();



	
}
